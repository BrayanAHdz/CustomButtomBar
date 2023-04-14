package com.reminder.custombuttombar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    LinearLayout homeLayout, likeLayout, notificationLayout, profileLayout;

    ImageView homeImg, likeImg, notificationImg, profileImg;

    TextView homeTxt, likeTxt, notificationTxt, profileTxt;
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeLayout = findViewById(R.id.homeLayout);
        likeLayout = findViewById(R.id.likeLayout);
        notificationLayout = findViewById(R.id.notificationLayout);
        profileLayout = findViewById(R.id.profileLayout);

        homeImg = findViewById(R.id.homeImg);
        likeImg = findViewById(R.id.likeImg);
        notificationImg = findViewById(R.id.notificationImg);
        profileImg = findViewById(R.id.profileImg);

        homeTxt = findViewById(R.id.homeTxt);
        likeTxt = findViewById(R.id.likeTxt);
        notificationTxt = findViewById(R.id.notificationTxt);
        profileTxt = findViewById(R.id.profileTxt);

        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmentContainer, HomeFragment.class, null)
                                        .commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout(1);
            }
        });

        likeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout(2);
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout(3);
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayout(4);
            }
        });
    }

    private void showLayout(int tab){

        if(selectedTab != tab){

            homeTxt.setVisibility(View.GONE);
            likeTxt.setVisibility(View.GONE);
            notificationTxt.setVisibility(View.GONE);
            profileTxt.setVisibility(View.GONE);

            homeImg.setImageResource(R.drawable.home_icon);
            likeImg.setImageResource(R.drawable.like_icon);
            notificationImg.setImageResource(R.drawable.notification_icon);
            profileImg.setImageResource(R.drawable.profile_icon);

            homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
            scaleAnimation.setDuration(200);
            scaleAnimation.setFillAfter(true);

            switch (tab){
                case 1:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, HomeFragment.class, null)
                            .commit();

                    homeTxt.setVisibility(View.VISIBLE);
                    homeImg.setImageResource(R.drawable.home_icon_selected);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home_100);
                    homeLayout.startAnimation(scaleAnimation);
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, LikeFragment.class, null)
                            .commit();

                    likeTxt.setVisibility(View.VISIBLE);
                    likeImg.setImageResource(R.drawable.like_icon_selected);
                    likeLayout.setBackgroundResource(R.drawable.round_back_like_100);
                    likeLayout.startAnimation(scaleAnimation);
                    break;
                case 3:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, NotificationFragment.class, null)
                            .commit();

                    notificationTxt.setVisibility(View.VISIBLE);
                    notificationImg.setImageResource(R.drawable.notification_icon_selected);
                    notificationLayout.setBackgroundResource(R.drawable.round_back_notification_100);
                    notificationLayout.startAnimation(scaleAnimation);
                    break;
                case 4:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, ProfileFragment.class, null)
                            .commit();

                    profileTxt.setVisibility(View.VISIBLE);
                    profileImg.setImageResource(R.drawable.profile_icon_selected);
                    profileLayout.setBackgroundResource(R.drawable.round_back_profile_100);
                    profileLayout.startAnimation(scaleAnimation);
                    break;

            }

            selectedTab = tab;
        }
    }
}