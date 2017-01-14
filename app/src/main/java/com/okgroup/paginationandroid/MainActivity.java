package com.okgroup.paginationandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.okgroup.paginationandroid.api.DataModel;
import com.okgroup.paginationandroid.api.RESTApi;
import com.okgroup.paginationandroid.api.ResponseModel;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ListView lv ;
    Button next, prev;
    Paginator p ;
    private  int totalPage = Paginator.TOTAL_NUM_ITEMS/Paginator.ITEM_PERPAGES;
    private int currentPage = 0;

    ArrayList<DataModel> dataApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataApi = new ArrayList<>();
        loadData();


        lv = (ListView) findViewById(R.id.listView);
        next = (Button) findViewById(R.id.nextBtn);
        prev = (Button) findViewById(R.id.previousBtn);
        prev.setEnabled(false);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage++;
                setAdapter();
                toogleButton();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage --;
                setAdapter();
                toogleButton();
            }
        });
    }


    void loadData(){
        final Call <ArrayList<DataModel>> data = RESTApi.get().getPost();
        data.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                Log.i("NEILBOTAK", "DATA "+ Arrays.toString(response.body().toArray()));

               
                dataApi = response.body();
                p = new Paginator(dataApi);
                setAdapter();
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Log.e("NULLBOTAK","ERR" , t );
            }
        });
    }



    void setAdapter() {
        lv.setAdapter(new AdapterListview(this,p.generatPage(currentPage)));
    }
    void toogleButton() {
        if(currentPage == totalPage){
            next.setEnabled(false);
            prev.setEnabled(true);
        }else if(currentPage ==0){
            prev.setEnabled(false);
            next.setEnabled(true);
        }else{
            prev.setEnabled(true);
            next.setEnabled(true);
        }

    }
}
