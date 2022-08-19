package com.example.pci_calenderview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.Toast;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;


import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
MaterialCalendarView calendarView;

/*
*     implementation 'com.github.prolificinteractive:material-calendarview:2.0.1'
    implementation 'com.jakewharton.threetenabp:threetenabp:1.1.1'
    * 빌드 그래들에 두개 추가하기
    * 세팅 그래들에        maven { url 'https://jitpack.io' } 추가하기
*
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarview);

        calendarView.state()
                .edit()
                .setMinimumDate(LocalDate.now().minusMonths(3)) //최소표현달
                .setMaximumDate(LocalDate.now().plusMonths(3))  //최대 표현달
               .commit();
        calendarView.setSelectionColor(Color.parseColor("#123456")); //선택된 날짜 색깔주기


        // 월, 요일을 한글로 보이게 설정 => Strings참고
        calendarView.setTitleFormatter(new MonthArrayTitleFormatter(getResources().getTextArray(R.array.custom_months)));
        calendarView.setWeekDayFormatter(new ArrayWeekDayFormatter(getResources().getTextArray(R.array.custom_weekdays)));

        //특정일에 파란색 점을 찍기위해서 필요한 데이터 나중에 DB에서 가지고오면됨
        ArrayList<CalendarDay> dates = new ArrayList<>(); //하루 , 이틀전에 대해서 파란점을 찍게만듬
            dates.add(CalendarDay.from(LocalDate.now().minusDays(1)));
            dates.add(CalendarDay.from(LocalDate.now().minusDays(2)));
        dates.add(CalendarDay.from(LocalDate.now().minusDays(1)));

        //addDecorators를이용해서 일요일 , 토요일에 색주고 , 특정일 ↑ 선택되게끔 데이터 넘김.
        calendarView.addDecorators(new SundayDecorator(),new SaturdayDecorator() , new EventDecorator(Color.RED, dates,this));
        calendarView.setSelectedDate(CalendarDay.today()); // 오늘 날짜를 선택하게 해둠.

        //날짜 클릭 시 이벤트를 발생시킴.
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.d("선택일자", date.getYear() + "년" + date.getMonth() +"월" + date.getDay() + "일 일자:" + date.getDate().toString());
            }
        });
    }

    //일요일 모양주기
    public class SundayDecorator implements DayViewDecorator {

        public SundayDecorator() {
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            int sunday = day.getDate().with(DayOfWeek.SUNDAY).getDayOfMonth();
            return sunday == day.getDay();
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new ForegroundColorSpan(Color.RED));
        }
    }

    //토요일 모양주기
    public class SaturdayDecorator implements DayViewDecorator {

        public SaturdayDecorator() {
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            int sunday = day.getDate().with(DayOfWeek.SATURDAY).getDayOfMonth();
            return sunday == day.getDay();
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new ForegroundColorSpan(Color.BLUE));
        }
    }


    //특정일 모양주기
    public class EventDecorator implements DayViewDecorator {

        private final Drawable drawable;
        private int color;
        private HashSet<CalendarDay> dates;

        public EventDecorator(int color, Collection<CalendarDay> dates, Activity context) {
            drawable = context.getResources().getDrawable(R.drawable.ic_baseline_arrow_drop_up_24);
            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(10, Color.BLUE)); // 날자밑에 점

        }
    }

}