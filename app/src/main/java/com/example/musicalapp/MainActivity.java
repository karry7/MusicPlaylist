package com.example.musicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Intent serviceIntent = new Intent(this, MyService.class);
        serviceIntent.setAction("START");
        serviceIntent.putExtra("chanson1", "bts1.mp3");

        startService(serviceIntent);*/
         button1= (Button) findViewById(R.id.button);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openActivity2();
             }
         });

    }
    public void demarrer(View view){
        Intent serviceIntent = new Intent(this, MyService.class);
        serviceIntent.setAction("START");
        serviceIntent.putExtra("chanson1", "bts1.mp3");

        startService(serviceIntent);
    }

    public void openActivity2(){
        Intent intent1 =new Intent(this,MyPlayList.class);
        startActivity(intent1);
    }
}