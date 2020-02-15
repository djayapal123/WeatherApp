package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_cityName;
    private Button getTempButton;
    private Button getForecastButton;
    private TextView tv_temperature;
    private LinearLayout ll_forecast;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

    }


    private void setViews() {
        et_cityName = findViewById(R.id.et_cityName);
        getTempButton = findViewById(R.id.getTempButton);
        tv_temperature = findViewById(R.id.tv_tempCelsius);
        ll_forecast = findViewById(R.id.ll_forecast);
        getForecastButton = findViewById(R.id.forecastButton);
        getTempButton.setOnClickListener(this);
        getForecastButton.setOnClickListener(this);

    }
    private void getTempData() {
        if(isNetworkAvailable()){
            WeatherApiInterface weatherApiInterface=ApiClient.getRetrofit().create(WeatherApiInterface.class);
            Call<TemperatureResponseModel> call = weatherApiInterface.getTemeratureData(et_cityName.getText().toString(),getString(R.string.app_id));
            Log.i(TAG, "URL: " + call.request().url());
            call.enqueue(new Callback<TemperatureResponseModel>() {
                @Override
                public void onResponse(Call<TemperatureResponseModel> call, Response<TemperatureResponseModel> response) {

                    Log.i(TAG, "Callback is in onResponse() of Retrofit");
                    Log.i(TAG, "Response Code " + response.code() + response.message());

                    if(null != response && response.code() == 200){
                        TemperatureResponseModel temperatureResponse=response.body();
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
                                    Toast.makeText(getApplicationContext(),R.string.no_city_alert, Toast.LENGTH_LONG).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<TemperatureResponseModel> call, Throwable t) {
                    Log.i(TAG, "Callback is in onFailure() of Retrofit");

                }
            });
        }
        else
            showErrorScreen(getString(R.string.network_error_message));

}

    private void getForecastData() {


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getTempButton:
                getTempData();
                break;
            case R.id.forecastButton:
                getForecastData();
                showAnimation();
                break;
            default:
                break;
        }
    }

    private void showAnimation(){
        if(!isForecastVisible()){
            ll_forecast.setVisibility(View.VISIBLE);
            Animation slide_up = AnimationUtils.loadAnimation(this, R.anim.slide_up);
            ll_forecast.startAnimation(slide_up);
            getForecastButton.setText(R.string.home_button_text);

        }else
        {
            ll_forecast.setVisibility(View.INVISIBLE);
            Animation slide_down = AnimationUtils.loadAnimation(this, R.anim.slide_down);
            ll_forecast.startAnimation(slide_down);
            getForecastButton.setText(R.string.forecast_button_text);
        }

    }
    private boolean isForecastVisible(){
        return ll_forecast.getVisibility() == View.VISIBLE;
    }

    private boolean isNetworkAvailable(){

        ConnectivityManager manager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if ((manager.getActiveNetworkInfo() != null) && manager.getActiveNetworkInfo()
                .isAvailable() && manager.getActiveNetworkInfo().isConnected()) {
            Log.i(TAG, "Network Available");
            return true;
        } else {
            Log.i(TAG, "Network Unavailable!!");
            return false;
        }
    }

    private void showErrorScreen(String message) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.alert)
                .setMessage(message)
                .setIcon(R.drawable.error)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getTempData();
                    }
                })
                .setCancelable(false)
                .create().show();
    }
}
