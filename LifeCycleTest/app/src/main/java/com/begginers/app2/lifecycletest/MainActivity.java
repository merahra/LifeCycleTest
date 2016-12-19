package com.begginers.app2.lifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvOutCreate,tvOutPause,tvOutResume;
    Button btnChileActivity;

    int count=0;
    int pauseCount=0;
    int resumeCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();

        count=count+1;
        tvOutCreate.setText(count+"");
        Log.d("myTagm","oncreate worked");
        btnChileActivity.setOnClickListener(this);
    }

    private void intiView() {
        tvOutCreate=(TextView)findViewById(R.id.tvOut1);
        tvOutPause=(TextView)findViewById(R.id.tvOut2);
        tvOutResume=(TextView)findViewById(R.id.tvOut3);
        btnChileActivity=(Button)findViewById(R.id.btnChileActivity);
    }

    protected void onPause(){
        super.onPause();
        pauseCount=pauseCount+1;
        tvOutPause.setText(pauseCount+"");
        Log.d("tmym","onpause worked");
    }
    protected void onResume(){
        super.onResume();
        resumeCount=resumeCount+1;
        tvOutResume.setText(resumeCount+"");
        Log.d("mytajm","onResume worked");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnChileActivity:
                Intent myChildIntent = new Intent(this,ChildActivity.class);
                startActivity(myChildIntent);
                break;
        }
    }
}
