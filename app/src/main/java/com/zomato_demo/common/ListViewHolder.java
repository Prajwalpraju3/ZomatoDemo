package com.zomato_demo.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.zomato_demo.ZomotoDetails.DetailsActivity;
import com.zomato_demo.databinding.ItemDetailsBinding;
import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.models.ListModel;
import com.zomato_demo.models.Restaurant_;

import java.util.HashMap;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    ItemDetailsBinding binding;

    public ListViewHolder(final Context context, View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                if (pos != -1) {

                    Restaurant_ model = binding.getRestorent();
                    if (!TextUtils.isEmpty(model.getId())) {


                            Intent myIntent = new Intent(view.getContext(), DetailsActivity.class);
                            myIntent.putExtra(Const.Params.ID, model.getId());
                            view.getContext().startActivity(myIntent);

                    }
                }
            }
        });

    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}