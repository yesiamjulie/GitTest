package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    private static final String CHANNEL_ID = "channel1";
    private static final String CHANNEL_NAME = "channel1";
    private static final String CHANNEL_ID2 = "channel2";
    private static final String CHANNEL_NAME2 = "channel2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);

        /*
                버튼 1,2에 대한 클릭 이벤트!

                사용자 -> 이벤트 등록
                운영체제 -> 특정 상황을 만족하면 실행
                ( 'Event Driven 방식')

         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti();
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailNoti();
            }
        });
    }

    public void showNoti() {


        /*  Service
        * Blocking vs Non-Blocking  ( 네이버 면접 문제 )
        * 막고 있음      막고 있지 않음
        * 순차성 보장    순차성 보장 x
        *  속도 느림      속도 빠름
        *  리소스 많이       리소스 적게  : cpu를 사용한다는 의미
        *
          Service는 기본적으로 Non-Blockcing이다.
          이전 시간에 배운 Input_stream, bufferd_stream은 blocking 방식이다. 순차성이 보장되어야 하기에!
        */

        /* 휴대폰에 알림 서비스를 제공하는 '시스템 객체'를 얻어옴 */
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        /*  안드로이드 버전이 여러가지가 있어서
        *   호환이 가능한 NotificationCompat을 사용한다.
        *   그리고 Builder는 알림을 어떤식으로 만들지를 결정한다. */
        NotificationCompat.Builder builder = null;

        /* SDK버전이 26보다 높다면 if문을 만족한다.
        *  안드로이드 SDK Version 26이후부터는
        *  Notification을 사용하기 위해
        *  휴대폰에서 별도의 설정이 필요해졌습니다.
        *  그래서 26을 기준으로 하고 있다.
        *
        *  우리가 초기 프로젝트 생성시 minimum support를 15로 설정해두었기에
        *  이번 경우에는 false이다. */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (manager.getNotificationChannel(CHANNEL_ID) != null) {
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
                ));

                //null이었던 builder를 객채화해줍니다.
                builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            }
            } else {

                /* 알림 객체를 만든다
                *  그러나 정보는 아무것도 설정되지 않은 상태 */
                builder = new NotificationCompat.Builder(this); // 없으면 현재것을 쓰겠습니다.( this)

            }

            /*setContentTitle : 알림의 제목 설정*/
            builder.setContentTitle("Simple Notification");

            /*알림의 제목 설정*/
            builder.setContentText("Alarm Message");

            /*아이콘을 배치하는 작업( 푸시알림에서 보이는 아이콘 )*/
            builder.setSmallIcon(android.R.drawable.ic_menu_view);

            /* 최종적으로 알림 객체를 완성한다.*/
            Notification noti = builder.build();

            /*notificationService가 알림을 하겠다!*/
            manager.notify(1, noti);

        }


    public void showDetailNoti() {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (manager.getNotificationChannel(CHANNEL_ID2) != null) {
                    manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID2, CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT
                ));

                //null이었던 builder를 객채화해줍니다.
                builder = new NotificationCompat.Builder(this, CHANNEL_ID2);
            }

        } else {
                builder = new NotificationCompat.Builder(this); // 없으면 현재것을 쓰겠습니다.( this)

            }

            builder.setContentTitle("Simple Notification");
            builder.setContentText("Alarm Message");
            builder.setSmallIcon(android.R.drawable.ic_menu_view);
            Notification noti = builder.build();

            manager.notify(2, noti);

            /*큰 글자로 강조하고 싶은 경우에 사용
            * 초기 설정과의 차이점이라면
            * setContentTitle 등에 Big이 붙어서
            * setBigContentTitle 정도로 변경된 형태라 보면 된다.
            *
            * setSummaryText()는 ContentTitle 안쪽에 들어가는 내용 */
            NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
            style.bigText("너만 오면 캐시템 지급!");
            style.setBigContentTitle("지금 접속하면, 10만원 상당의 캐시템 무료!");
            style.setSummaryText("3 주년 지급 이벤트 : 라그나로크, 봉인의 창, 피의 갑옷 지급!");

            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "channel3")
                    .setContentTitle("Subject")
                    .setContentTitle("Content").setSmallIcon(android.R.drawable.ic_menu_send)
                    .setStyle(style);

            Notification noti2 = builder2.build();

            manager.notify(2, noti2);

        }
    }

