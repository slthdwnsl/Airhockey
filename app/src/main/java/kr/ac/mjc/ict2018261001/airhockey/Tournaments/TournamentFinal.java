package kr.ac.mjc.ict2018261001.airhockey.Tournaments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.InfoActivity;
import kr.ac.mjc.ict2018261001.airhockey.MainActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.ShareActivity;
import kr.ac.mjc.ict2018261001.airhockey.R;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.SettingActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.SupportActivity;
import kr.ac.mjc.ict2018261001.airhockey.Spinner.Data;

public class TournamentFinal extends AppCompatActivity {

    TextView TeamRedScore,TeamBlueScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament_final);
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
                        Intent intent = new Intent(TournamentFinal.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent2 = new Intent(TournamentFinal.this, SettingActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.support:
                        Intent intent3 = new Intent(TournamentFinal.this, SupportActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.about_us:
                        Intent intent4 = new Intent(TournamentFinal.this, InfoActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.share:
                        Intent intent6 = new Intent(TournamentFinal.this, ShareActivity.class);
                        startActivity(intent6);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(TournamentFinal.this, TournamentFinal.class);
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
                        Intent intent8 = new Intent(TournamentFinal.this, MainActivity.class);
                        startActivity(intent8);
                        finish();
                        break;
                    case R.id.setting:
                        Intent intent11 = new Intent(TournamentFinal.this, SettingActivity.class);
                        startActivity(intent11);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(TournamentFinal.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                }
                return false;
            }
        });

        fetchdata();
        TeamRedScore = findViewById(R.id.team_red_score);
        TeamBlueScore = findViewById(R.id.team_blue_score);
    }
    public void fetchdata(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Team_score");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    String red_score = snapshot.child("red_score").getValue().toString();
                    TeamRedScore.setText(red_score);
                    String blue_score = snapshot.child("blue_score").getValue().toString();
                    TeamBlueScore.setText(blue_score);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (Integer.parseInt(red_score) >= 5){
                                Intent intent = new Intent(TournamentFinal.this, Red_win.class);
                                startActivity(intent);
                                for(DataSnapshot snapshot2 : snapshot.getChildren()){
                                    snapshot2.getRef().setValue(0);
                                }
                            } else if (Integer.parseInt(blue_score) >= 5) {
                                Intent intent = new Intent(TournamentFinal.this, Blue_win.class);
                                startActivity(intent);
                                for(DataSnapshot snapshot2 : snapshot.getChildren()){
                                    snapshot2.getRef().setValue(0);
                                }
                            }
                        }
                    }, 2000);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

   /* private void refresh(int milliseconds){

        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                fetchdata();
            }
        };

        handler.postDelayed(runnable, milliseconds);
    }*/

}
