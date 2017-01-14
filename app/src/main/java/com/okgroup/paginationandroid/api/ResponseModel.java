package com.okgroup.paginationandroid.api;

import java.util.ArrayList;

/**
 * Created by ww3 on 14/01/17.
 */

public class ResponseModel {
    ArrayList<DataModel> data ;

    public ResponseModel(ArrayList<DataModel> data) {
        this.data = data;
    }

    public ArrayList<DataModel> getData() {
        return data;
    }

    public void setData(ArrayList<DataModel> data) {
        this.data = data;
    }
}
