package com.zomato_demo.ViewModels;

import android.app.Application;

import com.zomato_demo.models.Restaurant_;
import com.zomato_demo.NetworkManager.DetailsManager;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class DeatailsViewModel extends BaseViewModel {

    private LiveData<Restaurant_> liveData;
    private ObservableField<Restaurant_> observableField = new ObservableField<>();
    DetailsManager detailsManager;
    public DeatailsViewModel(Application application, String id){
        super(application);
        detailsManager = new DetailsManager(application);
        callNextPageResult(id);
//        this.liveData = new StoreDetailsManager(application).getListModelRequest(page,id);
    }

    private void callNextPageResult(String id){
        this.liveData= detailsManager.getRestaurant_Request(id);
    }


    public LiveData<Restaurant_> getObservable() {
        return liveData;
    }

    public void setModel(Restaurant_ model) {
        this.observableField.set(model);
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String id;

        public Factory(@NonNull Application application, String id) {
            this.application = application;
            this.id = id;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new DeatailsViewModel(application,id);
        }
    }

}
