package com.divyansh.dagger2_rxjava_mvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.divyansh.dagger2_rxjava_mvvm.BaseActivity;
import com.divyansh.dagger2_rxjava_mvvm.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MAIN ACTIVITY", Toast.LENGTH_SHORT).show();
    }
}
