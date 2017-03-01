package com.example.gauravsingh.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
TextView tv;
    EditText ed;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=(TextView)findViewById(R.id.textView);
        ed=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button4);
        Intent i= getIntent();
        Bundle bundle=i.getExtras();
        String s= bundle.getString("time");
        String s1=bundle.getString("date");
        tv.setText( s + "\n" + s1 );
    }
    public void per(View v) {
        Intent i= new Intent();
       String s= ed.getText().toString().trim();
        if(s.length()>0) {
            setResult(RESULT_OK, i);
            i.putExtra("place",s);
            ed.setText("");
            finish();
        }

    }
}
