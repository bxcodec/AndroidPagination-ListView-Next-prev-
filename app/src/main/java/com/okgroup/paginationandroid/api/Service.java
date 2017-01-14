package com.okgroup.paginationandroid.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ww3 on 14/01/17.
 */

public interface Service {

    @GET("posts")
    Call<ArrayList<DataModel>> getPost();
}
