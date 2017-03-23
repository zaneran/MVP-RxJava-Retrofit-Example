package zhuoranhuang.example.api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zaneran on 3/23/2017.
 */

public interface WeatherAPI {
    @GET("0,0")
    Observable<WeatherBean> getBean();
}
