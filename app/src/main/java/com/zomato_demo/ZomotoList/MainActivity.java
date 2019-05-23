package com.zomato_demo.ZomotoList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.zomato_demo.R;
import com.zomato_demo.ViewModels.DeatailsViewModel;
import com.zomato_demo.ViewModels.ListViewModel;
import com.zomato_demo.ZomotoDetails.DetailsActivity;
import com.zomato_demo.common.ListAdapter;
import com.zomato_demo.common.SpacesItemDecoration;
import com.zomato_demo.databinding.ActivityMainBinding;
import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.models.ListModel;
import com.zomato_demo.models.Restaurant;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListViewModel listViewModel;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLocation(0);
        ListViewModel.Factory factory = new ListViewModel.Factory(getApplication(), "", "", "");
        listViewModel = ViewModelProviders.of(MainActivity.this, factory).get(ListViewModel.class);
        observeViewModel();
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                listViewModel.callNextPageResult(s.toString()," "," ");
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//
//                    }
//                }, 10);
            }
        });
    }


    private void observeViewModel() {
        // Observe project data
        listViewModel.getObservable().observe(this, new Observer<ListModel>() {
            @Override
            public void onChanged(ListModel listModel) {
                if (listModel != null) {
                    RecyclerView recyclerView = binding.rvList;
                    recyclerView.addItemDecoration(new SpacesItemDecoration(30));
                    linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setNestedScrollingEnabled(true);

                    Log.d("ttt", "onChanged: ------>"+listModel.getRestaurants().get(0).getRestaurant().getName());

                    if (listModel.getRestaurants().size() > 0) {
                        setupRecyclerView("temp", recyclerView, listModel.getRestaurants());

                    }
                }
            }
        });
    }

    ListAdapter listAdapter;

    private void setupRecyclerView(String title, final RecyclerView rvStoreList, final List<Restaurant> detailsModels) {
        listAdapter = new ListAdapter(title, this, detailsModels);
        rvStoreList.setAdapter(listAdapter);

    }
}
