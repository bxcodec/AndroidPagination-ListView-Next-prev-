package com.okgroup.paginationandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ww3 on 14/01/17.
 */

public class RESTApi {

    public final static String END_POINT = "https://jsonplaceholder.typicode.com";

    private static Service service;

    private static Retrofit retrofit;
    static{

        setup();

    }

    public   static Service get (){
        return  service;
    }
    public static  void setup(){
        retrofit = new Retrofit.Builder().baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);


    }
}
