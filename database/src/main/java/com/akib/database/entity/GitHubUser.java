package com.akib.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.core.model
 */
@Entity
public class GitHubUser {
    @NonNull
    @PrimaryKey()
    private String login;
    @ColumnInfo(name = "nodeId")
    private String nodeId;
    @ColumnInfo(name = "avatarUrl")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
