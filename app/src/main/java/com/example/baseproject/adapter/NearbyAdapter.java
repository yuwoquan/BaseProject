package com.example.baseproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.services.core.PoiItem;
import com.bumptech.glide.Glide;
import com.example.baseproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.ViewHolder> {

    private Context context;

    private List<PoiItem> poiItems = new ArrayList<>();


    public void setData(List<PoiItem> poiItems) {
        this.poiItems = poiItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearby_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = viewGroup.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PoiItem poiItem = poiItems.get(i);
        viewHolder.cafesName.setText(poiItem.getTitle());
        viewHolder.cafesType.setText(poiItem.getTypeDes());
        if (poiItem.getBusinessArea().equals("")) {
            viewHolder.cafesBusinessArea.setVisibility(View.GONE);
        }
        viewHolder.cafesBusinessArea.setText(poiItem.getBusinessArea());
        viewHolder.cafesRating.setText(poiItem.getPoiExtension().getmRating());
        viewHolder.cafesAddress.setText(poiItem.getProvinceName() + poiItem.getCityName() + poiItem.getAdName() + poiItem.getSnippet());
        if (poiItem.getPhotos().size() > 0) {
            Glide.with(context).load(poiItem.getPhotos().get(0).getUrl()).into(viewHolder.cafesImage);
            Log.e("ttt", "onBindViewHolder: "+poiItem.getPhotos().get(0).getUrl() );
        }
    }

    @Override
    public int getItemCount() {
        return poiItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cafes_image)
        ImageView cafesImage;
        @BindView(R.id.cafes_name)
        TextView cafesName;
        @BindView(R.id.cafes_type)
        TextView cafesType;
        @BindView(R.id.cafes_business_area)
        TextView cafesBusinessArea;
        @BindView(R.id.cafes_address)
        TextView cafesAddress;
        @BindView(R.id.cafes_rating)
        TextView cafesRating;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
