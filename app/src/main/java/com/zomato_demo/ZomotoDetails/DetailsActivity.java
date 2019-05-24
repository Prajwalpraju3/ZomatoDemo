package com.zomato_demo.ZomotoDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zomato_demo.R;
import com.zomato_demo.ViewModels.DeatailsViewModel;
import com.zomato_demo.common.Const;
import com.zomato_demo.databinding.ActivityDetailsBinding;
import com.zomato_demo.models.Restaurant_;

public class DetailsActivity extends AppCompatActivity {

    public ActivityDetailsBinding binding;
    private String res_id = "";
    DeatailsViewModel deatailsViewModel;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setActivity(DetailsActivity.this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (!TextUtils.isEmpty(bundle.getString(Const.Params.ID))) {
                res_id = bundle.getString(Const.Params.ID);
            }
        }

        binding.pg.setVisibility(View.VISIBLE);
        binding.ll.setVisibility(View.GONE);


        DeatailsViewModel.Factory factory = new DeatailsViewModel.Factory(getApplication(), res_id);
        deatailsViewModel = ViewModelProviders.of(DetailsActivity.this, factory).get(DeatailsViewModel.class);

        observeViewModel();
        binding.btDeeplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Uri myAction = Uri.parse("http:" + id);
                    PackageManager packageManager = getPackageManager();
                    Intent intent = packageManager.getLaunchIntentForPackage("com.application.zomato");

                    if (intent != null) {
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(myAction);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }



    private void observeViewModel() {
        // Observe project data
        deatailsViewModel.getObservable().observe(this, new Observer<Restaurant_>() {
            @Override
            public void onChanged(Restaurant_ restaurant) {
                if (restaurant != null) {
                    binding.pg.setVisibility(View.GONE);
                    binding.ll.setVisibility(View.VISIBLE);
                    binding.setRestorent(restaurant);
                    id = restaurant.getDeeplink();


                }
            }
        });
    }


}
