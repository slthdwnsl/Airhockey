package kr.ac.mjc.ict2018261001.airhockey.Tournaments;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import kr.ac.mjc.ict2018261001.airhockey.MainActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.InfoActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.SettingActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.ShareActivity;
import kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys.SupportActivity;
import kr.ac.mjc.ict2018261001.airhockey.R;
import www.sanju.motiontoast.MotionToast;

public class Red_win extends AppCompatActivity {

    TextView textView11;
    TextView teamWinner;
    Button backBtn,restartBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_win);

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
                        Intent intent = new Intent(Red_win.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.setting:
                        Intent intent2 = new Intent(Red_win.this, SettingActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.support:
                        Intent intent3 = new Intent(Red_win.this, SupportActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.about_us:
                        Intent intent4 = new Intent(Red_win.this, InfoActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.share:
                        Intent intent6 = new Intent(Red_win.this, ShareActivity.class);
                        startActivity(intent6);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(Red_win.this, TournamentFinal.class);
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
                        Intent intent8 = new Intent(Red_win.this, MainActivity.class);
                        startActivity(intent8);
                        break;
                    case R.id.game:
                        Intent intent1 = new Intent(Red_win.this, TournamentFinal.class);
                        startActivity(intent1);
                        break;
                    case R.id.setting:
                        Intent intent11 = new Intent(Red_win.this, SettingActivity.class);
                        startActivity(intent11);
                        break;
                }
                return false;
            }
        });

        fetchdata();

        textView11 = findViewById(R.id.textView11);
        teamWinner = findViewById(R.id.team_winner);
        backBtn = findViewById(R.id.back_btn);
        restartBtn = findViewById(R.id.restart_btn);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Red_win.this, TournamentFinal.class);
                startActivity(intent1);
            }
        });

    }
    public void fetchdata(){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        DocumentReference documentReference = firestore.collection("player").document("player1");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            teamWinner.setText(documentSnapshot.getString("name3"));
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
