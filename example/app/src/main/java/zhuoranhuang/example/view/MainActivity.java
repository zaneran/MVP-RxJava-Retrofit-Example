package zhuoranhuang.example.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import zhuoranhuang.example.R;
import zhuoranhuang.example.presenter.Presenter;

public class MainActivity extends AppCompatActivity  implements MainInterface {

    TextView latView;
    TextView lngView;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latView = (TextView) findViewById(R.id.lat);
        lngView = (TextView) findViewById(R.id.lng);
        presenter = new Presenter(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.subscribe();
        presenter.findCoordinate();
    }

    @Override
    public void onPause(){
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setLat(String lat) {
        latView.setText(lat);
    }

    @Override
    public void setLng(String lng) {
        lngView.setText(lng);
    }
}
