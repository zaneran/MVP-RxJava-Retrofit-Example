package zhuoranhuang.example.presenter;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import zhuoranhuang.example.api.WeatherBean;
import zhuoranhuang.example.model.Model;
import zhuoranhuang.example.view.MainInterface;

/**
 * Created by zaneran on 3/23/2017.
 */

public class Presenter {
    MainInterface mainInterface;
    //prevent frequent requests before last one completed.
    private CompositeSubscription compositeSubscription;
    private boolean isRefreshing = false;
    Model model = new Model();

    public Presenter(MainInterface mainInterface){
        this.mainInterface = mainInterface;
    }

    public void findCoordinate(){
        if (!isRefreshing) {
            isRefreshing = true;
            Subscription subscription = model.getCoordinate()
                    .subscribe(new Subscriber<WeatherBean>() {
                        @Override
                        public void onCompleted() {
                            isRefreshing = false;
                        }

                        @Override
                        public void onError(Throwable e) {
                            //gather error information and toast in view layer.
                        }

                        @Override
                        public void onNext(WeatherBean weatherBean) {
                            mainInterface.setLat(weatherBean.getLatitude());
                            mainInterface.setLng(weatherBean.getLongitude());
                        }
                    });
            compositeSubscription.add(subscription);
        }
    }

    public void unsubscribe(){
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
        }
        isRefreshing = false;
    }

    public void subscribe(){
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed()){
            compositeSubscription = new CompositeSubscription();
        }
    }
}
