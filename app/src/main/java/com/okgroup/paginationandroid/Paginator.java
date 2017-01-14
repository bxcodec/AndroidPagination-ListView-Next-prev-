package com.okgroup.paginationandroid;

import com.okgroup.paginationandroid.api.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ww3 on 14/01/17.
 */

public class Paginator {
    public static   int TOTAL_NUM_ITEMS;
    public static   final int ITEM_PERPAGES = 1;
    public static   int ITEM_REMAINING;
    public static   int LAST_PAGE;
    List<DataModel> dataModels;
    public Paginator(List<DataModel> data) {
        dataModels = data;
        TOTAL_NUM_ITEMS = dataModels.size();
        ITEM_REMAINING = TOTAL_NUM_ITEMS/ITEM_PERPAGES;
        LAST_PAGE = TOTAL_NUM_ITEMS % ITEM_PERPAGES;
    }
    public ArrayList<DataModel> generatPage(int currentPage){
        ArrayList<DataModel> pageData  = new ArrayList<>();

           int startItem = currentPage*ITEM_PERPAGES+1;
            int numOfItem =ITEM_PERPAGES;


        if(currentPage == LAST_PAGE && ITEM_REMAINING==0){
            for(int i =startItem; i<startItem+ITEM_REMAINING; i++){
                pageData.add(dataModels.get(i));
            }
        }else {
            for (int i = startItem; i< startItem+numOfItem;i++){
                pageData.add(dataModels.get(i));
            }
        }
        return pageData;
    }

}
