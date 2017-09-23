package com.programadorandroid.roomsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.programadorandroid.roomsample.data.entity.Place;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    //Views
    private TextView messageTextView;

    //Presenter
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = (TextView) findViewById(R.id.messageTextView);

        presenter = new MainPresenter(this,this);

        presenter.setup();
    }

    @Override
    public void showPlaces(List<Place> places) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Place place : places) {
            stringBuilder.append(place.getName());
            stringBuilder.append(",");
        }
        messageTextView.setText(stringBuilder.toString());
    }
}
