package com.example.y.calendarschedule_demo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.TimePickerView;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeChooseActivity extends Activity implements OnDateSetListener {
    private TimePickerDialog mDialogAll;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_choose);

        Button button = findViewById(R.id.time_picker);

        button.setOnClickListener(v -> {
            TimePickerView pvTime = new TimePickerBuilder(this, (date, v1) -> {
                Toast.makeText(TimeChooseActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                Log.i("pvTime", "onTimeSelect");
                    })
                    .setTimeSelectChangeListener(date -> Log.i("pvTime", "onTimeSelectChanged"))
                    .setType(new boolean[]{true, true, true, true, true, false})
                    .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                    .addOnCancelClickListener(view -> Log.i("pvTime", "onCancelClickListener"))
                    .setItemVisibleCount(5) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                    .setLineSpacingMultiplier(2.0f)
                    .isAlphaGradient(true)
                    .build();

            Dialog mDialog = pvTime.getDialog();
            if (mDialog != null) {

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        Gravity.BOTTOM);

                params.leftMargin = 0;
                params.rightMargin = 0;
                pvTime.getDialogContainerLayout().setLayoutParams(params);

                Window dialogWindow = mDialog.getWindow();
                if (dialogWindow != null) {
                    dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                    dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                    dialogWindow.setDimAmount(0.3f);
                }
            }

            pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
            pvTime.show();
//            mDialogAll = new TimePickerDialog.Builder()
//                    .setCallBack(this)
//                    .setCancelStringId("Cancel")
//                    .setSureStringId("Sure")
//                    .setTitleStringId("TimePicker")
//                    .setYearText("Year")
//                    .setMonthText("Month")
//                    .setDayText("Day")
//                    .setHourText("Hour")
//                    .setMinuteText("Minute")
//                    .setCyclic(false)
//                    .setMinMillseconds(System.currentTimeMillis())
//                    .setCurrentMillseconds(System.currentTimeMillis())
//                    .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
//                    .setType(Type.ALL)
//                    .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
//                    .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
//                    .setWheelItemTextSize(12)
//                    .build();
        });
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        Log.e("TAG", "millseconds:"+millseconds );
        Log.e("TAG", "systemTime:"+System.currentTimeMillis() );
    }
}
