package com.zomato_demo.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zomato_demo.BR;
import com.zomato_demo.R;
import com.zomato_demo.ZomotoList.MainActivity;
import com.zomato_demo.databinding.ItemDetailsBinding;
import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.models.ListModel;
import com.zomato_demo.models.Restaurant;
import com.zomato_demo.models.Restaurant_;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Restaurant> list;

    public ListAdapter( final Context context, List<Restaurant> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDetailsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_details, parent, false);
        return new ListViewHolder(context, binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ListViewHolder) {
            ListViewHolder listViewHolder= (ListViewHolder) holder;
            Restaurant_ listModel = list.get(position).getRestaurant();
            ItemDetailsBinding binding = (ItemDetailsBinding) listViewHolder.getBinding();
            binding.setVariable(BR.restorent,listModel);
            binding.executePendingBindings();

        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


}
