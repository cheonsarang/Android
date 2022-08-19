package com.example.lastporject_hiclass.calendar;

import android.content.Context;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lastporject_hiclass.R;
import com.example.lastporject_hiclass.calendar.decorator.EventDecorator;
import com.example.lastporject_hiclass.calendar.decorator.SaturdayDecorator;
import com.example.lastporject_hiclass.calendar.decorator.SundayDecorator;
import com.example.lastporject_hiclass.calendar.decorator.TodayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class CalendarFragment extends Fragment {
    MaterialCalendarView calendarView;
    Context context;
    public CalendarFragment( Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = v.findViewById(R.id.calendarView);
        calendarView.setSelectedDate(CalendarDay.today());
        calendarView.addDecorator(new TodayDecorator());
        calendarView.addDecorator(new SundayDecorator());
        calendarView.addDecorator(new SaturdayDecorator());

        ArrayList<CalendarDay> dates = new ArrayList<>();



        calendarView.addDecorator(new EventDecorator(Color.RED, dates, context));



        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

            }
        });









        return v;
    }
}