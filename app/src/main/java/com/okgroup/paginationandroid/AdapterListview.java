package com.okgroup.paginationandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.okgroup.paginationandroid.api.DataModel;

import java.util.List;

/**
 * Created by ww3 on 14/01/17.
 */

public class AdapterListview  extends BaseAdapter{

    Context mcontext ;
    List<DataModel> data;

    public AdapterListview(Context c , List<DataModel> data) {
        mcontext = c;
        this.data= data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder vh = new Holder();

        if (view == null){
            LayoutInflater inflater = ((Activity)mcontext).getLayoutInflater();
            view = inflater.inflate(R.layout.item_view,viewGroup,false);
            vh.id = (TextView) view.findViewById(R.id.idPost);
            vh.userId = (TextView) view.findViewById(R.id.userId);
            vh.title = (TextView) view.findViewById(R.id.titlePost);
            vh.body= (TextView) view.findViewById(R.id.bodyPost);
            view.setTag(vh);
        }
        else {

            vh = (Holder) view.getTag();
        }


        vh.userId.setText("userid : " + String.valueOf(data.get(i).getUserId()));
        vh.id.setText("id post: "+ String.valueOf(data.get(i).getId()));
        vh.body.setText("body : "+ data.get(i).getBody());
        vh.title.setText("title " + data.get(i).getTitle());
        return view;

    }

    private class  Holder {
        public TextView userId;
        public TextView id;
        public TextView title;
        public TextView body;
    }
}
