package com.responsi.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView mTextName;
    TextView mTextPhone;
    TextView mTExtEmail;
    ImageView mImagePeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    private void init() {
        mImagePeople = findViewById(R.id.iv_people);
        mTextName = findViewById(R.id.tv_name);
        mTextPhone = findViewById(R.id.tv_phone);
        mTExtEmail = findViewById(R.id.tv_email);

        Intent intent = getIntent();

        Glide.with(this)
                .load(intent.getStringExtra("image"))
                .into(mImagePeople);

        mTextName.setText(intent.getStringExtra("name"));
        mTExtEmail.setText(intent.getStringExtra("phone"));
        mTextPhone.setText(intent.getStringExtra("email"));
    }
}
