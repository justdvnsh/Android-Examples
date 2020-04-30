package com.divyansh.retrofitwithrxandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.retrofitwithrxandroid.R;
import com.divyansh.retrofitwithrxandroid.network.pojo.Datum;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userViewHolder> {

    private Context context;
    private List<Datum> results;

    public UserAdapter(Context context, List<Datum> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public UserAdapter.userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.userViewHolder holder, int position) {
        Log.i("result", String.valueOf(results.size()));
        Datum result = results.get(position);
        holder.name.setText(result.getFirstName());
        holder.email.setText(result.getEmail());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Datum> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public class userViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView email;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
