package zhuoranhuang.example.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zaneran on 3/23/2017.
 */

public class APIwrapper {
    static Retrofit retrofit;
    static WeatherAPI weatherAPI;

    public static WeatherAPI getWeatherAPI(){
        if (weatherAPI == null){
            weatherAPI = getRetrofit().create(WeatherAPI.class);
        }
        return weatherAPI;
    }

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.darksky.net/forecast/41ab7fc743a4891c7f684e228c128bcd/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
