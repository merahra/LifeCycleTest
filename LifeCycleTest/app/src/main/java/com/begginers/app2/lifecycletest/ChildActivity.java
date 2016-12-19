package com.begginers.app2.lifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvOutC,tvOutP,tvOutR;
    Button btnMainActivity;

    int countCh=0,pauseCountCh=0,resumeCountCh=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        initView();
        Log.d("myTag","oncreate worked");
        countCh=countCh+1;
        tvOutC.setText(countCh+"");

        btnMainActivity.setOnClickListener(this);

    }
    protected void onPause(){
        super.onPause();
        pauseCountCh=pauseCountCh+1;
        tvOutP.setText(pauseCountCh+"");
        Log.d("tmy","onpause worked");
    }
    protected void onResume(){
        super.onResume();
        resumeCountCh=resumeCountCh+1;
        tvOutR.setText(resumeCountCh+"");
        Log.d("mytaj","onResume worked");
    }

    private void initView() {
        tvOutC=(TextView)findViewById(R.id.tvOut12);
        tvOutP=(TextView)findViewById(R.id.tvOut13);
        tvOutR=(TextView)findViewById(R.id.tvOut14);
        btnMainActivity=(Button)findViewById(R.id.btnMainActivity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMainActivity:
                Intent myMainIntent = new Intent(this,MainActivity.class);
                startActivity(myMainIntent);
                break;
        }
    }
}
