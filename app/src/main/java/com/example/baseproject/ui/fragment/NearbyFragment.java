package com.example.baseproject.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.baseproject.R;
import com.example.baseproject.adapter.NearbyAdapter;
import com.example.baseproject.mvp.ui.base.BaseFragment;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NearbyFragment extends BaseFragment implements PoiSearch.OnPoiSearchListener{

    private static final String TAG = "NearbyFragment";
    @BindView(R.id.nearby_recycler)
    RecyclerView nearbyRecycler;
    @BindView(R.id.refresh)
    ImageView refresh;
    private Boolean isfirst=false;


    @Override
    public void onResume() {
        super.onResume();

    }

    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (isfirst){
                return;
            }
            Log.e(TAG, "onLocationChanged: "+aMapLocation.getErrorCode() );
            PoiSearch.Query query = new PoiSearch.Query("网吧网咖", "", "");
            PoiSearch poiSearch = new PoiSearch(NearbyFragment.this.getContext(),query);
            //设置周边搜索的中心点以及半径
            poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), 5000));
            poiSearch.setOnPoiSearchListener(NearbyFragment.this);
            poiSearch.searchPOIAsyn();
            //停止定位后，本地定位服务并不会被销毁
            mLocationClient.stopLocation();
            isfirst=true;
        }
    };

    private NearbyAdapter nearbyAdapter;


    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_nearby, null);
        ButterKnife.bind(this, view);
        initRecycler();
        initMap();
        return view;
    }

    private void initMap() {
        //初始化定位
        mLocationClient = new AMapLocationClient(this.getActivity().getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    private void initRecycler() {
        nearbyAdapter = new NearbyAdapter();
        nearbyRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        nearbyRecycler.setAdapter(nearbyAdapter);
    }


    @OnClick(R.id.refresh)
    public void onRefreshClick() {
        mLocationClient.startLocation();
    }


    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        ArrayList<PoiItem> poiItems = poiResult.getPois();
        nearbyAdapter.setData(poiItems);
        nearbyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {
    }
}
