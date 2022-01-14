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
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Créé",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service détruit",Toast.LENGTH_LONG).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service démmaré",Toast.LENGTH_LONG).show();
        String namefile= (String) intent.getExtras().get("chanson1");
        int IDfichierAudio = getResources().getIdentifier(namefile,"raw", getPackageName());
        player.create(this, IDfichierAudio);
        player.start();
        return START_STICKY;
    }
}