package com.example.android.attendance_management_system.activities;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.attendance_management_system.R;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        ProgressAnimation();

    }

    private void ProgressAnimation() {

        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);
        anim.setDuration(3000);
        progressBar.setAnimation(anim);

    }
}

/*new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        openSelect_Login();
                    }
                }
                , 1000);
    }


    Intent intent = new Intent(this, select_Login.class);
        startActivity(intent);
*/