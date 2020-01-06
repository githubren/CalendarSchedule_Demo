package com.example.y.calendarschedule_demo;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Iterator;

import cn.aigestudio.datepicker.bizs.calendars.DPCManager;
import cn.aigestudio.datepicker.bizs.decors.DPDecor;
import cn.aigestudio.datepicker.views.DatePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOne = (Button) findViewById(R.id.btn_one);
        Button btnTwo = (Button) findViewById(R.id.btn_two);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                Intent intentOne = new Intent(this,DateChooseActivity.class);
                startActivity(intentOne);
                break;
            case R.id.btn_two:
                Intent intentTwo = new Intent(this,TimeChooseActivity.class);
                startActivity(intentTwo);
                break;
        }
    }
}
