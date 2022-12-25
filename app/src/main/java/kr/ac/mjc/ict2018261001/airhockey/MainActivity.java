package kr.ac.mjc.ict2018261001.airhockey;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import kr.ac.mjc.ict2018261001.airhockey.Themes.OnSwipeTouchListener;
import kr.ac.mjc.ict2018261001.airhockey.Themes.ThemeUtil;
import kr.ac.mjc.ict2018261001.airhockey.Tournaments.TournamentFinal;
import www.sanju.motiontoast.MotionToast;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1000;
    LinearLayout linearLayout,linearLayout3;
    ImageView imageView;
    TextView textView,textView2;
    int count = 0;
    String themeColor;
    Animation top,bottom,center1,center2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button startBtn = findViewById(R.id.start_btn);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout3 = findViewById(R.id.linearLayout3);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);
        center1 = AnimationUtils.loadAnimation(this,R.anim.center1);
        center2 = AnimationUtils.loadAnimation(this,R.anim.center2);

        linearLayout.setAnimation(top);
        textView2.setAnimation(top);
        linearLayout3.setAnimation(bottom);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setAnimation(center1);
                textView2.setAnimation(center1);
                linearLayout3.setAnimation(center2);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, TournamentFinal.class);
                        startActivity(intent);
                    }
                },SPLASH_SCREEN);
            }
        });
        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    textView.setText("Night");
                    count = 1;
                    startBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this,TournamentFinal.class);
                            startActivity(intent);
                            themeColor = ThemeUtil.DARK_MODE;
                            ThemeUtil.applyTheme(themeColor);
                            ThemeUtil.modSave(getApplicationContext(),themeColor);
                        }
                    });
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    textView.setText("Morning");
                    count = 0;
                    startBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this,TournamentFinal.class);
                            startActivity(intent);
                            themeColor = ThemeUtil.LIGHT_MODE;
                            ThemeUtil.applyTheme(themeColor);
                            ThemeUtil.modSave(getApplicationContext(),themeColor);
                        }
                    });
                }
            }

            public void onSwipeLeft() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    textView.setText("Night");
                    count = 1;
                    startBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this,TournamentFinal.class);
                            startActivity(intent);
                            themeColor = ThemeUtil.DARK_MODE;
                            ThemeUtil.applyTheme(themeColor);
                            ThemeUtil.modSave(getApplicationContext(),themeColor);
                        }
                    });
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    textView.setText("Morning");
                    count = 0;
                    startBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this,TournamentFinal.class);
                            startActivity(intent);
                            themeColor = ThemeUtil.LIGHT_MODE;
                            ThemeUtil.applyTheme(themeColor);
                            ThemeUtil.modSave(getApplicationContext(),themeColor);
                        }
                    });
                }
            }

            public void onSwipeBottom() {
            }

        });
    }
}