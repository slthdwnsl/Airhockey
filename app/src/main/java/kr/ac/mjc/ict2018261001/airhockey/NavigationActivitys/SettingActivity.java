package kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
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

public class SettingActivity extends AppCompatActivity {

    SwitchCompat musicSw,modeSw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        musicSw = findViewById(R.id.music_sw);
        modeSw = findViewById(R.id.mode_sw);
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        musicSw.setChecked(sharedPreferences.getBoolean("value",true));
        modeSw.setChecked(sharedPreferences.getBoolean("value",true));

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        musicSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true){
                    startService(new Intent(getApplicationContext(), MusicService.class));
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    musicSw.setChecked(true);
                }
                else{
                    stopService(new Intent(getApplicationContext(), MusicService.class));
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    musicSw.setChecked(false);
                }
            }
        });

        modeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    modeSw.setChecked(true);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    modeSw.setChecked(false);
                }
            }
        });


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
                        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent2 = new Intent(SettingActivity.this, SettingActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.support:
                        Intent intent3 = new Intent(SettingActivity.this, SupportActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.about_us:
                        Intent intent4 = new Intent(SettingActivity.this, InfoActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.game:
                    Intent intent1 = new Intent(SettingActivity.this, TournamentFinal.class);
                    startActivity(intent1);
                    break;
                    case R.id.share:
                        Intent intent6 = new Intent(SettingActivity.this, ShareActivity.class);
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
                        Intent intent8 = new Intent(SettingActivity.this, MainActivity.class);
                        startActivity(intent8);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(SettingActivity.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                    case R.id.setting:
                        Intent intent11 = new Intent(SettingActivity.this, SettingActivity.class);
                        startActivity(intent11);
                        break;
                }
                return false;
            }
        });
    }
}


