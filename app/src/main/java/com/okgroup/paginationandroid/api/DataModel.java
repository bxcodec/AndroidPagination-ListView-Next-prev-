package com.okgroup.paginationandroid.api;

/**
 * Created by ww3 on 14/01/17.
 */

public class DataModel {
    public final int userId;
    public final int id ;
    public final String title;
    public final String body;

    public DataModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
