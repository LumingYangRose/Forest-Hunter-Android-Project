package message;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import edu.neu.madcourse.forest_hunter.MainActivity;
import edu.neu.madcourse.forest_hunter.R;


public class MessagingService extends FirebaseMessagingService {
    private static final String TAG = MessagingService.class.getSimpleName();
    private static final String CHANNEL_ID  = "CHANNEL_ID";
    private static final String CHANNEL_NAME  = "CHANNEL_NAME";
    private static final String CHANNEL_DESCRIPTION  = "CHANNEL_DESCRIPTION";


    @Override
    public void onNewToken(String newToken) {

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone sound = RingtoneManager.getRingtone(getApplicationContext(), notification);
        sound.play();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            sound.setLooping(false);
        }

        // vibration
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {100, 300};
        vibrator.vibrate(pattern, -1);


        myClassifier(remoteMessage);



    }


    private void myClassifier(RemoteMessage remoteMessage) {

        String identificator = remoteMessage.getFrom();
        if (identificator != null) {
            if (identificator.contains("topic")) {
                if (remoteMessage.getNotification() != null) {
                    RemoteMessage.Notification notification = remoteMessage.getNotification();
                    showNotification(remoteMessage.getNotification());
                    Utils.postToastMessage(notification.getTitle(), getApplicationContext());
                }
            } else {
                if (remoteMessage.getData().size() > 0) {
                    RemoteMessage.Notification notification = remoteMessage.getNotification();
                    showNotification(notification);
                    Utils.postToastMessage(remoteMessage.getData().get("title"), getApplicationContext());
                }
            }
        }
    }


    @Deprecated
    private void showNotification(RemoteMessage remoteMessage) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Notification notification;
        NotificationCompat.Builder builder;
        NotificationManager notificationManager = getSystemService(NotificationManager.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        } else {
            builder = new NotificationCompat.Builder(this);
        }

        int drawableResourceId = this.getResources().getIdentifier("pic_main_menu_title", "drawable", this.getPackageName());

        Bitmap title_bitmap = BitmapFactory.decodeResource(this.getResources(), drawableResourceId);

        NotificationCompat.BigPictureStyle big_picture_notification = new NotificationCompat.BigPictureStyle().bigPicture(title_bitmap).bigLargeIcon(null);
        big_picture_notification.setSummaryText("Image");


        notification = builder.setContentTitle(remoteMessage.getNotification().getTitle())
                .setStyle(big_picture_notification)
                .setLargeIcon(title_bitmap)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(0, builder.build());

    }

    private void showNotification(RemoteMessage.Notification remoteMessageNotification) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Notification notification;
        NotificationCompat.Builder builder;
        NotificationManager notificationManager = getSystemService(NotificationManager.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        } else {
            builder = new NotificationCompat.Builder(this);
        }

        int drawableResourceId = this.getResources().getIdentifier("pic_main_menu_title", "drawable", this.getPackageName());

        Bitmap title_bitmap = BitmapFactory.decodeResource(this.getResources(), drawableResourceId);

        NotificationCompat.BigPictureStyle big_picture_notification = new NotificationCompat.BigPictureStyle().bigPicture(title_bitmap).bigLargeIcon(null);
        big_picture_notification.setSummaryText("Image");

        builder.setContentTitle(remoteMessageNotification.getTitle())
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent);

        builder.setStyle(big_picture_notification);

        builder.setLargeIcon(title_bitmap);

        notificationManager.notify(0, builder.build());

    }



}
