package com.divyansh.retrofitwithrxandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.divyansh.retrofitwithrxandroid.adapter.UserAdapter;
import com.divyansh.retrofitwithrxandroid.network.APIClient;
import com.divyansh.retrofitwithrxandroid.network.APIEndpoints;
import com.divyansh.retrofitwithrxandroid.network.pojo.Datum;
import com.divyansh.retrofitwithrxandroid.network.pojo.User;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private APIEndpoints apiEndpoints;
    private CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        apiEndpoints = APIClient.getInstance().create(APIEndpoints.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new UserAdapter(this, new ArrayList<Datum>());
        recyclerView.setAdapter(adapter);

        disposable = new CompositeDisposable();

        fetchUsers();
    }

    private void fetchUsers() {
        Call<User> call = apiEndpoints.getUsers();
        Log.i("call", call.request().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    adapter.setResults(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Error", t.getMessage());
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
