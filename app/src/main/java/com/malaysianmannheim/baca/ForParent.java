package com.malaysianmannheim.baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

public class ForParent extends AppCompatActivity {
ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_parent);
        StatusBarUtil.setTransparent(this);

        //open Home activity
        backButton = (ImageView) findViewById(R.id.backButtonImageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForParent.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}