package com.example.musicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyPlayList extends AppCompatActivity {
ListView mylist;
    String songs[] = {"song1","song2","song3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        mylist= findViewById(R.id.listview1);
        mylist.setAdapter(adaptor);

mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        String p = parent.getItemAtPosition(i).toString(); //element cliqué
        startmusic(p);
    }
});

    }

    public void startmusic(String song){
        Intent intent =new Intent(this,MyService.class);
        intent.setAction("START");
        intent.putExtra("chanson",song);
        startService(intent);
    }

}