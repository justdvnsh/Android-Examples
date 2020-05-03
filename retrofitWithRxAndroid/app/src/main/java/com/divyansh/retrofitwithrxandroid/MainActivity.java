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
import java.util.List;
import java.util.Observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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

        disposable.add(apiEndpoints.getUsers().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
        .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(User user) {
        adapter.setResults(user.getData());
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(this, "Failed " + throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
