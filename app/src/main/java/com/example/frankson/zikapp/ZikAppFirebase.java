package com.example.frankson.zikapp;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import es.dmoral.toasty.Toasty;

import static android.R.attr.duration;
import static android.R.attr.y;

public class ZikAppFirebase extends FirebaseMessagingService {



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        final String msg = remoteMessage.getNotification().getBody();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            public void run() {
                Toasty.info(getBaseContext(), msg).show();
            }
        });
    }
}
