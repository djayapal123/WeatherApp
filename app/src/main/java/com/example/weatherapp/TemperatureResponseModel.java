package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class TemperatureResponseModel {

    @SerializedName("main")
    public Main main;

    class Main {
        @SerializedName("temp")
        public float temp;

        public float getTemp() {
            return temp;
        }
    }

    public Main getMain() {
        return main;
    }


}
