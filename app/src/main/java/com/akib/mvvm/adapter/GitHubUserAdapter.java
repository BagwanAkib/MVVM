package com.akib.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akib.database.entity.GitHubUser;
import com.akib.mvvm.R;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.mvvm.adapter
 */
public class GitHubUserAdapter extends RecyclerView.Adapter<GitHubUserAdapter.ViewHolder> {
    private Context context;
    private ArrayList<GitHubUser> users;

    public GitHubUserAdapter(Context context, ArrayList<GitHubUser> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.github_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTxtLogin().setText(users.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtLogin;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLogin = itemView.findViewById(R.id.txt_login);
        }

        TextView getTxtLogin() {
            return txtLogin;
        }
    }
}
