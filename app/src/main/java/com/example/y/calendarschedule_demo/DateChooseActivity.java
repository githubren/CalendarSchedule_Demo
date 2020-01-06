package com.example.y.calendarschedule_demo;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Iterator;

import cn.aigestudio.datepicker.bizs.calendars.DPCManager;
import cn.aigestudio.datepicker.bizs.decors.DPDecor;
import cn.aigestudio.datepicker.views.DatePicker;

public class DateChooseActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_choose);

//        DatePicker datePicker = findViewById(R.id.date_picker);
//        datePicker.setDate(2020,1);
//        datePicker.setOnDateSelectedListener(date -> {
//            String result = "";
//            Iterator iterator = date.iterator();
//            while (iterator.hasNext()) {
//                result += iterator.next();
//                if (iterator.hasNext()) {
//                    result += "\n";
//                }
//            }
//            Toast.makeText(DateChooseActivity.this, result, Toast.LENGTH_LONG).show();
//        });
    }
}
