package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

class ErrorResponseModel {
    @SerializedName("message")
    public String message;

    public String getMessage() {
        return message;
    }
}
