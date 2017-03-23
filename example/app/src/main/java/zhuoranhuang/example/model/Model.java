package zhuoranhuang.example.model;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhuoranhuang.example.api.APIwrapper;
import zhuoranhuang.example.api.WeatherBean;

/**
 * Created by zaneran on 3/23/2017.
 */

public class Model {
    public Observable<WeatherBean> getCoordinate(){
        return APIwrapper.getWeatherAPI()
                .getBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
