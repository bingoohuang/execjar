package com.github.bingoohuang.execjar;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttp {

  public static final OkHttpClient client =
      new OkHttpClient.Builder()
          .connectTimeout(10, TimeUnit.SECONDS)
          .writeTimeout(10, TimeUnit.SECONDS)
          .readTimeout(10, TimeUnit.SECONDS)
          .build();
}
