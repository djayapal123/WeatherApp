package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText et_cityName;
    private Button getTempButton;
    private TextView tv_temperature;
    private String appId = "d03f99c03a561a0541a762bc572fa766";
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        getTempData();
    }

    private void setViews() {
        et_cityName = findViewById(R.id.et_cityName);
        getTempButton = findViewById(R.id.getTempButton);
        tv_temperature = findViewById(R.id.tv_tempCelsius);
        getTempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTempData();
            }
        });
    }
    private void getTempData() {

        WeatherApiInterface weatherApiInterface=ApiClient.getRetrofit().create(WeatherApiInterface.class);
        Call<TemperatureResponse> call = weatherApiInterface.getTemeratureData(et_cityName.getText().toString(),appId);
        Log.i(TAG, "URL: " + call.request().url());
        call.enqueue(new Callback<TemperatureResponse>() {
            @Override
            public void onResponse(Call<TemperatureResponse> call, Response<TemperatureResponse> response) {

                Log.i(TAG, "Callback is in onResponse() of Retrofit");
                Log.i(TAG, "Response Code " + response.code() + response.message());

                if(null != response && response.code() == 200){
                    TemperatureResponse temperatureResponse=response.body();
                    Log.i(TAG, temperatureResponse.getMain().toString());
                    Float tempInKelvin= temperatureResponse.getMain().getTemp();
                    float tempInCelsius = tempInKelvin - 273.15F;
                    tv_temperature.setText(String.valueOf(tempInCelsius) + " C");

                }
                else if(null != response && response.code() == 404){
                   if(null != response.errorBody()) {
                       String error;
                       try {
                           error = response.errorBody().string();
                           ErrorResponseModel model = new Gson().fromJson(error, ErrorResponseModel.class);
                           if(model.getMessage().equals("city not found")){
                               Toast.makeText(getApplicationContext(),"Please give correct city name", Toast.LENGTH_LONG).show();
                           }
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
                }
            }


            @Override
            public void onFailure(Call<TemperatureResponse> call, Throwable t) {
                Log.i(TAG, "Callback is in onFailure() of Retrofit");

            }
        });
    }


}
