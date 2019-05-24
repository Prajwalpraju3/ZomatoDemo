package com.zomato_demo.NetworkManager;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zomato_demo.Interfaces.ApiInterface;
import com.zomato_demo.Interfaces.DataCallBackListener;
import com.zomato_demo.R;
import com.zomato_demo.common.AppUtils;
import com.zomato_demo.models.ListModel;

import retrofit2.Call;


public class ListManager {
    private Context context;
    private Call<ListModel> modelCall;
    private PreferenceManager preferenceManager;
    private final MutableLiveData<ListModel> data;
    private int page_count=10;
    public ListManager(Context context){
        this.context=context;
        preferenceManager=new PreferenceManager(context);
        data = new MutableLiveData<>();
    }

    public LiveData<ListModel> getListModelRequest(String id,String lat,String lon) {
        if (!AppUtils.isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
            return data;
        }

       ApiInterface storeInterface = NetworkGenerator.getAuthClient(context).create(ApiInterface.class);
        modelCall = storeInterface.getLists("",id,lat,lon);
        BaseManager baseManager = new BaseManager(context);
        baseManager.sendRequest(modelCall, new DataCallBackListener() {
            @Override
            public void onResponse(Object body) {
                if (body instanceof ListModel) {
                    ListModel detailsModel = (ListModel) body;
                    data.setValue(detailsModel);

                }
            }

            @Override
            public void onError(Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }


    public void cancelRequest() {
        modelCall.cancel();
    }
}
