package com.project.udacity.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_android_white_24dp);
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String question  = intent.getStringExtra("Question");
        final String answer = intent.getStringExtra("Answer");
        TextView txt_question = findViewById(R.id.txt_question);
        final ImageView img_emoji = findViewById(R.id.img_emoji);
        final TextView txt_answer = findViewById(R.id.txt_answer);
        final View view = findViewById(R.id.view);
        Button btn_answer = findViewById(R.id.btn_answer);
        txt_answer.setVisibility(View.GONE);
        img_emoji.setVisibility(View.GONE);
        txt_question.setText(question);
        txt_answer.setText(answer);
        view.setVisibility(View.GONE);
        if(question == null)
        {
            txt_question.setText("Please try again or check your internet connection");
            btn_answer.setVisibility(View.GONE);
        }
        btn_answer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    txt_answer.setVisibility(View.VISIBLE);
                    img_emoji.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
            }
        });

    }
}
