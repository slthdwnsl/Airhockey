package kr.ac.mjc.ict2018261001.airhockey.NavigationActivitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import kr.ac.mjc.ict2018261001.airhockey.BuildConfig;
import kr.ac.mjc.ict2018261001.airhockey.R;

public class ShareActivity extends AppCompatActivity {

    Button shareBtn;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        shareBtn = findViewById(R.id.share);
        imageView = findViewById(R.id.share_image);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Let's play airhockey (applink)"+getPackageName());
                startActivity(Intent.createChooser(sendIntent,""));
            }
        });
    }
}
