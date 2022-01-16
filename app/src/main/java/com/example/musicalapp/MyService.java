package com.example.musicalapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer player = new MediaPlayer();

    @Override
    public IBinder onBind(Intent intent) {
     return null;
    }

    @Override
    public void onDestroy() {

        player.stop();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);

        if(intent.getAction()=="START") {
            String namefile = (String) intent.getExtras().get("chanson");
            int IDfichierAudio = getResources().getIdentifier(namefile, "raw", getPackageName());
            player = MediaPlayer.create(this, IDfichierAudio);

            player.setLooping(true);
            player.start();

        }
        return result;

    }
}