package com.example.cyt.howold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button mGetImage;
    private Button mDetect;
    private TextView mTip;
    private View mWaiting;

    private String mCurrentPhotoStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        
        initEvents();
    }

    private void initEvents() {
        mGetImage.setOnClickListener(this);
        mDetect.setOnClickListener(this);
    }

    private void initViews() {
        imageView = findViewById(R.id.imageview);
        mGetImage = findViewById(R.id.btn_get);
        mDetect = findViewById(R.id.btn_detect);
        mTip = findViewById(R.id.tv_tip);
        mWaiting = findViewById(R.id.id_waiting);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                break;
            case R.id.btn_detect:
                break;
        }

    }
}
