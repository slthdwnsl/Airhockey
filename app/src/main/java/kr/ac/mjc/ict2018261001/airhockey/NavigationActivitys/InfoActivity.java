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

public class InfoActivity extends AppCompatActivity {

    Button originalBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        originalBtn = findViewById(R.id.original_btn);

        originalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://create.arduino.cc/projecthub/silas_hansen/air-football-cabfb7?ref=search&ref_id=air%20hockey&offset=0";

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
                        Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent2 = new Intent(InfoActivity.this, SettingActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.support:
                        Intent intent3 = new Intent(InfoActivity.this, SupportActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.about_us:
                        Intent intent4 = new Intent(InfoActivity.this, InfoActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(InfoActivity.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                    case R.id.share:
                        Intent intent6 = new Intent(InfoActivity.this, ShareActivity.class);
                        startActivity(intent6);
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
                        Intent intent8 = new Intent(InfoActivity.this, MainActivity.class);
                        startActivity(intent8);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(InfoActivity.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                    case R.id.setting:
                        Intent intent11 = new Intent(InfoActivity.this, SettingActivity.class);
                        startActivity(intent11);
                        break;
                }
                return false;
            }
        });
    }
}
