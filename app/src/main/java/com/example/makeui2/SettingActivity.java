package com.example.makeui2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class SettingActivity extends AppCompatActivity {


    //레이아웃 선언
    static RadioButton visual_button;
    RadioButton unvisual_button;

    RadioButton visual_button2;
    RadioButton unvisual_button2;

    RadioButton visual_button3;
    RadioButton unvisual_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.next_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setTitle("환경설정"); // 툴바 제목 설정
//레이아웃 객체 생성
        visual_button = findViewById(R.id.visual_button);
        unvisual_button = findViewById(R.id.unvisual_button);

        visual_button2 = findViewById(R.id.visual_button2);
        unvisual_button2 = findViewById(R.id.unvisual_button2);

        visual_button3 = findViewById(R.id.visual_button3);
        unvisual_button3 = findViewById(R.id.unvisual_button3);

        //라디오버튼 객체 생성
        RadioGroup colorType = findViewById(R.id.colorType);

        RadioGroup colorType2 = findViewById(R.id.colorType2);

        RadioGroup colorType3 = findViewById(R.id.colorType3);


        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        String[] test = {"2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984"};
        SpinnerAdapter s1Adapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, test);
        s1.setAdapter(s1Adapter);

        //라디오버튼 체크시 이벤트
        colorType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.visual_button)
                {
                    visual_button.setBackgroundColor(Color.rgb(158,158,158));
                    unvisual_button.setBackgroundColor(Color.rgb(249,249,249));

                }else if(checkedId == R.id.unvisual_button)
                {
                    visual_button.setBackgroundColor(Color.rgb(249,249,249));
                    unvisual_button.setBackgroundColor(Color.rgb(158,158,158));
                }




            }

        });



        colorType2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.visual_button2)
                {
                    visual_button2.setBackgroundColor(Color.rgb(158,158,158));
                    unvisual_button2.setBackgroundColor(Color.rgb(249,249,249));

                }else if(checkedId == R.id.unvisual_button2)
                {
                    visual_button2.setBackgroundColor(Color.rgb(249,249,249));
                    unvisual_button2.setBackgroundColor(Color.rgb(158,158,158));
                }

            }
        });


        colorType3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.visual_button3)
                {
                    visual_button3.setBackgroundColor(Color.rgb(158,158,158));
                    unvisual_button3.setBackgroundColor(Color.rgb(249,249,249));

                }else if(checkedId == R.id.unvisual_button3)
                {
                    visual_button3.setBackgroundColor(Color.rgb(249,249,249));
                    unvisual_button3.setBackgroundColor(Color.rgb(158,158,158));
                }

            }
        });



    }

    public class SpinnerAdapter extends ArrayAdapter<String> {
        Context context;
        String[] items = new String[]{};

        public SpinnerAdapter(final Context context,
                              final int textViewResourceId, final String[] objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
            this.context = context;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_dropdown_item, parent, false);
            }

            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(items[position]);

            tv.setTextSize(30);
            tv.setHeight(50);
            return convertView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);

            tv.setTextSize(30);
            return convertView;
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {

    //return super.onCreateOptionsMenu(menu);
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.main_menu, menu);
    return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                // 액티비티 이동
                finish();
                return true;
            }
            case R.id.menu_home:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "홈화면 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
