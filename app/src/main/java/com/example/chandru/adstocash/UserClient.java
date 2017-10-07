package com.example.chandru.adstocash;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chandru on 10/7/2017.
 */

public interface UserClient {

    @POST("base api after '.com/' na  ")
    Call<User> createACcount(@Body  User user);


}
