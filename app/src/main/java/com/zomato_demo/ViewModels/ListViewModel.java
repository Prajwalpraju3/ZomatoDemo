package com.zomato_demo.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.zomato_demo.NetworkManager.ListManager;
import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.models.ListModel;


public class ListViewModel extends BaseViewModel {

    private LiveData<ListModel> liveData;
    private ObservableField<DetailsModel> observableField = new ObservableField<>();
    private ListManager listManager;
    private ListViewModel(Application application, String id,String lat, String lon){
        super(application);
        listManager = new ListManager(application);
        callNextPageResult(id,lat,lon);
//        this.liveData = new StoreDetailsManager(application).getListModelRequest(page,id);
    }

    public void callNextPageResult(String id,String lat, String lon){
        this.liveData= listManager.getListModelRequest(id,lat,lon);
    }


    public LiveData<ListModel> getObservable() {
        return liveData;
    }



    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String id;
        private final String lat;
        private final String lon;

        public Factory(@NonNull Application application, String id,String lat, String lon) {
            this.application = application;
            this.id = id;
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ListViewModel(application,id,lat,lon);
        }
    }

}
