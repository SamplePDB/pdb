package com.reachuson.app.pdb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class Type_checker extends AppCompatActivity {
    private ProgressBar Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_checker);
        Spinner = (ProgressBar)findViewById(R.id.progressBar2);
        Spinner.setVisibility(View.GONE);
    }
}
