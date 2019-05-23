package com.zomato_demo.Interfaces;

import com.zomato_demo.models.DetailsModel;
import com.zomato_demo.common.Const;
import com.zomato_demo.models.ListModel;
import com.zomato_demo.models.Restaurant_;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
//    @GET(Const.Route.STORE_LIST_URL)
//    Call<DetailsModel> geStoreModelResponse();

    @GET(Const.Local.RESTAURANT)
    Call<Restaurant_> getDetails(@Query("res_id") String res_id);

    @GET(Const.Local.SEARCH)
    Call<ListModel> getLists(@Query("entity_type") String entity_type,@Query("q") String q,@Query("lat") String lat,@Query("lon") String lon );
}
