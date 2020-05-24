package com.akib.core;

import com.akib.database.entity.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bagwan Akib on  5/24/2020
 */
public interface ApiInterface {

    @GET("users")
    Call<List<GitHubUser>> getGitHubUser();
}
