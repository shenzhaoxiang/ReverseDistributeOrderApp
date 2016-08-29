package com.ctsig.rdo.base;

/**
 * @des:
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 17:30
 */
public abstract class BaseModel<API> {
//    private API mService;
//
//    public BaseModel() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(getClient())
//                .build();
//
//        mService = retrofit.create(getApiClass());
//    }
//
//    @NonNull
//    private OkHttpClient getClient() {
//
//        BasicParamsInterceptor basicParamsInterceptor =
//               new BasicParamsInterceptor.Builder()
//                        //.addHeaderParam("device_id", DeviceUtils.getDeviceId())
//                        //.addParam("uid", UserModel.getInstance().getUid())
//                        .addQueryParam("api_version", "1.1")
//                        .build();
//
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
//
//        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//        okHttpBuilder.addInterceptor(basicParamsInterceptor);
//        okHttpBuilder.addInterceptor(loggingInterceptor);
//
//        return okHttpBuilder.build();
//    }
//    public API getService() {
//        return mService;
//    }
//    protected abstract Class<API> getApiClass();

}

