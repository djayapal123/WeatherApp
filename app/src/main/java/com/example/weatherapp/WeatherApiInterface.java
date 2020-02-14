package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {
    @GET("data/2.5/weather?")
    Call<TemperatureResponse> getTemeratureData(@Query("q")String city, @Query("appid") String appId);
}
