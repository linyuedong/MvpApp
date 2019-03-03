package com.me.mvplib.http;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.me.mvplib.Utils.CommonUtils;
import com.me.mvplib.base.BaseApplication;
import com.me.mvplib.http.interceptor.logging.Level;
import com.me.mvplib.http.interceptor.logging.LoggingInterceptor;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static Retrofit.Builder mRetrofitBuilder = null;
    private static volatile OkHttpClient mOkHttpClient = null;
    public static final long CONNECTION_TIMEOUT = 60;
    public static final long READ_TIMEOUT = 60;
    public static final long WRETE_TIMEOUT = 60;
    public static final int cacheSize = 10 * 1024 * 1024;

    private RetrofitManager(){

    }

    public static RetrofitManager getInstance(){
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder {
        private static RetrofitManager INSTANCE = new RetrofitManager();

    }

    @NonNull
    public  synchronized <T> T createService(String baseUrl,@NonNull Class<T> serviceClass) {
        return createWrapperService(baseUrl,serviceClass);
    }

    /**
     * 根据 https://zhuanlan.zhihu.com/p/40097338 对 Retrofit 进行的优化
     *
     * @param serviceClass ApiService class
     * @param <T> ApiService class
     * @return ApiService
     */
    private  <T> T createWrapperService(String baseUrl ,Class<T> serviceClass) {
        CommonUtils.checkNotNull(serviceClass, "serviceClass == null");

        // 二次代理
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, @Nullable Object[] args)
                            throws Throwable {
                        // 此处在调用 serviceClass 中的方法时触发

                        if (method.getReturnType() == Observable.class) {
                            // 如果方法返回值是 Observable 的话，则包一层再返回，
                            // 只包一层 defer 由外部去控制耗时方法以及网络请求所处线程，
                            // 如此对原项目的影响为 0，且更可控。
                            return Observable.defer(() -> {
                                final T service = getRetrofitService(baseUrl,serviceClass);
                                // 执行真正的 Retrofit 动态代理的方法
                                return ((Observable) getRetrofitMethod(service, method)
                                        .invoke(service, args));
                            });
                        } else if (method.getReturnType() == Single.class) {
                            // 如果方法返回值是 Single 的话，则包一层再返回。
                            return Single.defer(() -> {
                                final T service = getRetrofitService(baseUrl,serviceClass);
                                // 执行真正的 Retrofit 动态代理的方法
                                return ((Single) getRetrofitMethod(service, method)
                                        .invoke(service, args));
                            });
                        }

                        // 返回值不是 Observable 或 Single 的话不处理。
                        final T service = getRetrofitService(baseUrl,serviceClass);
                        return getRetrofitMethod(service, method).invoke(service, args);
                    }
                });
    }

    private static HashMap<String, Object> mRetrofitServiceCache = new HashMap<>();

    private <T> T getRetrofitService(String baseUrl,Class<T> serviceClass) {
        T retrofitService = (T) mRetrofitServiceCache.get(serviceClass.getCanonicalName());
        if (retrofitService == null) {
            retrofitService = mRetrofitBuilder.baseUrl(baseUrl).build().create(serviceClass);
            mRetrofitServiceCache.put(serviceClass.getCanonicalName(), retrofitService);
        }
        return retrofitService;
    }

    private <T> Method getRetrofitMethod(T service, Method method) throws NoSuchMethodException {
        return service.getClass().getMethod(method.getName(), method.getParameterTypes());
    }


    static{
        mRetrofitBuilder = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置超时
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(WRETE_TIMEOUT, TimeUnit.SECONDS);
        //设置缓存
        File file = new File(BaseApplication.getContext().getCacheDir(), "Okcache");
        Cache cache = new Cache(file, cacheSize);
        builder.cache(cache);
        //日志拦截器
        builder.addInterceptor(new LoggingInterceptor
                .Builder()//构建者模式
                .loggable(BaseApplication.isDebug()) //是否开启日志打印
                .setLevel(Level.BASIC) //打印的等级
                .log(Platform.INFO) // 打印类型
                .request("-Request") // request的Tag
                .response("-Response")// Response的Tag
                .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
                .build());

        //错误重连
        builder.retryOnConnectionFailure(true);
        mOkHttpClient = builder.build();

        return mOkHttpClient;
    }

}