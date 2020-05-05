package com.example.notesapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

public class NotificationButton extends AppCompatActivity {

    private static final String CHANNEL_ID = "ID";
    private static final String CHANNEL_NAME = "channelName";
    private static final String CHANNEL_DESC = "Motivation Button Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        findViewById(R.id.notification_motivation_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotifications();
            }
        });
    }
    private String[] quoteArray = {"Simplicity is the ultimate sophistication",
            "Never regret anything that made you smile",
            "Every moment is a fresh beginning",
            "Prove them wrong",
            "He who is brave is free",
            "No guts, no story",
            "Leave no stone unturned",
            "Do it with passion or not at all",
            "Every noble work is at first impossible",
            "The wisest mind has something yet to learn",
            "If you're going through hell, keep going",
            "Persistence guarantees that results are inevitable",
            "It is better to live one day as a lion, than one thousand days as a lamb",
            "You can do it!",
            "You make mistakes. Mistakes don't make you"
    };
    public static String randomQuote(String[] inputArray) {
        Random r = new Random();
        int randomValue = r.nextInt(inputArray.length - 1);
        return inputArray[randomValue];
    }
    public void addNotifications() {

        // Notification builder
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("A little motivation!")
                .setContentText(randomQuote(quoteArray))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat nManagerCompat = NotificationManagerCompat.from(this);
        nManagerCompat.notify(1, notificationBuilder.build());

    }
}
