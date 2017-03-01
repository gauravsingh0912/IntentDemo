package com.example.gauravsingh.intentdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
Button b,b1,b2;
    String s1,s2;
    TimePickerDialog tpd;
    DatePickerDialog dpd;
    TextView tv,tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        tv=(TextView)findViewById(R.id.textView3);
        tv1=(TextView)findViewById(R.id.textView4);
        tv2=(TextView)findViewById(R.id.textView7);
        tpd=new TimePickerDialog(this,lis,4,15,true);
        tpd.setCancelable(false);
        tpd.setTitle("Pick Time");
        dpd=new DatePickerDialog(this,liss,2017,1,25);
        dpd.setCancelable(false);
        dpd.setTitle("Pick Date");
    }
    TimePickerDialog.OnTimeSetListener lis= new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            tv.setText("Time Picked is  "+i+":"+i1);
        }
    };
    DatePickerDialog.OnDateSetListener liss= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int month ,int i2) {
            tv1.setText("Date Picked is  "+i2+ "/"+(month +1)+ "/"+i);
        }
    };

    public void fun(View v)
    {
        switch(v.getId())
        {
            case R.id.button:
                tpd.show();
                break;
            case R.id.button2:
                dpd.show();
                break;

            case R.id.button3:
                Intent i = new Intent(this,SecondActivity.class);
                s1=tv.getText().toString().trim();;
                s2=tv1.getText().toString().trim();
                Bundle bundle=new Bundle();
                bundle.putString("time",s1);
                bundle.putString("date",s2);
                if(s1.length()>0&&s2.length()>0){
                i.putExtras(bundle);
                //startActivity(i);
                }
                startActivityForResult(i,1);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                tv2.setText("Place is "+ data.getStringExtra("place"));
            }
        }

    }


}
