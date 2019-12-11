package com.example.firebasepushmessage;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class TestFirebaseMessagingService extends FirebaseMessagingService {
    public TestFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size() > 0){
            Log.d("test", "Message data payload" + remoteMessage.getData());
            if (false) {
                //For long-running tasks ( 10 seconds or more) use WorkManager.
                scheduleJob();
            }else{
                handleNow(remoteMessage);
            }

            //Check if message contains a notification payload
            if (remoteMessage.getNotification() != null) {
                Log.d("test", "Message Notification Body :" + remoteMessage.getNotification());

            }
        }

    }

    @Override
    public void onNewToken(String token) {
        Log.d("test", "onNewtoken token = " + token);
    }

    private void handleNow(RemoteMessage remoteMessage) {
        Log.d("test", "handleNow in");
        sendNotification(remoteMessage.getData().get("message"));
    }

    private void sendRegistrationToServer(String token) {
        Log.d("test", "onNewToken token = " + token);
    }
    private void scheduleJob() {
        Log.d("test", "scheduleJob in");
    }


    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "1000";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Since android Oreo notification Channel is needed.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel((channelId),
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);

        }
        notificationManager.notify(0,notificationBuilder.build());
    }


}

