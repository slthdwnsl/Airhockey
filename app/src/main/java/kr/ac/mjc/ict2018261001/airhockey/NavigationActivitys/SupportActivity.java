package kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import kr.ac.mjc.ict2018261001.airhockey.MainActivity;
import kr.ac.mjc.ict2018261001.airhockey.R;
import kr.ac.mjc.ict2018261001.airhockey.Tournaments.TournamentFinal;

public class SupportActivity extends AppCompatActivity {

    Button NaverBtn, GmailBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        NaverBtn = findViewById(R.id.naver_mail);
        GmailBtn = findViewById(R.id.gmail);

        NaverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://mail.naver.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        GmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://gmail.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(SupportActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent2 = new Intent(SupportActivity.this, SettingActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.support:
                        Intent intent3 = new Intent(SupportActivity.this, SupportActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.about_us:
                        Intent intent4 = new Intent(SupportActivity.this, InfoActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.share:
                        Intent intent6 = new Intent(SupportActivity.this, ShareActivity.class);
                        startActivity(intent6);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(SupportActivity.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent8 = new Intent(SupportActivity.this, MainActivity.class);
                        startActivity(intent8);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent11 = new Intent(SupportActivity.this, SettingActivity.class);
                        startActivity(intent11);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(SupportActivity.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                }
                return false;
            }
        });
    }
}
