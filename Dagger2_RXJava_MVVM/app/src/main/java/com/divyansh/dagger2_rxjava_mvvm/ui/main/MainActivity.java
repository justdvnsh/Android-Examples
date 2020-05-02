package com.divyansh.dagger2_rxjava_mvvm.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.divyansh.dagger2_rxjava_mvvm.BaseActivity;
import com.divyansh.dagger2_rxjava_mvvm.R;
import com.divyansh.dagger2_rxjava_mvvm.SessionManager;
import com.divyansh.dagger2_rxjava_mvvm.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MAIN ACTIVITY", Toast.LENGTH_SHORT).show();
        testFragment();
    }

    private void testFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new ProfileFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            sessionManager.logOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
