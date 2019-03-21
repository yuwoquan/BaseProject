package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.mvp.movie.MoviePresenter;
import com.example.baseproject.mvp.movie.MovieView;
import com.example.baseproject.mvp.ui.AbstractMvpFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailFragment extends AbstractMvpFragment<MovieView, MoviePresenter> implements MovieView {

    private static final String TAG = "MovieDetailFragment";
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.image) ImageView image;
    @BindView(R.id.moviename) TextView moviename;
    @BindView(R.id.star) TextView star;
    @BindView(R.id.zhuyan) TextView zhuyan;
    @BindView(R.id.zuozhe) TextView zuozhe;
    @BindView(R.id.time) TextView time;
    @BindView(R.id.jianjie) TextView jianjie;
    @BindView(R.id.type) TextView type;
    @BindView(R.id.country) TextView country;
    private Bundle bundle;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_movie_detail, null);
        ButterKnife.bind(this, view);
        bundle = getArguments();
        String id = bundle.getString("id");
        getPresenter().clickLoadMovie(id);
        return view;
    }


    @Override
    public void successgetIntheat(InTheatersBean inTheatersBean) {

    }

    @Override
    public void successgetMovieDetai(MovieDetailBean movieDetailBean) {
        setTopbar(mtopbar, movieDetailBean.getTitle());
        jianjie.setText("简介："+"\n\n\u3000"+movieDetailBean.getSummary());
        Glide.with(MyApplication.getContext()).load(movieDetailBean.getImages().getMedium()).into(image);
        List<MovieDetailBean.DirectorsBean> listAuthor=movieDetailBean.getDirectors();
        for (MovieDetailBean.DirectorsBean authorName:listAuthor){
            zuozhe.setText("导演："+authorName.getName());
        }
        List<MovieDetailBean.CastsBean> listcast=movieDetailBean.getCasts();
        StringBuffer str = new StringBuffer();
        int i = 1;
        for (MovieDetailBean.CastsBean subcast:listcast){
            String cast=subcast.getName();
            if(listcast.size()==i){
                str.append(cast);
            }else{
                str.append(cast+"，");
            }
            i++;
        }
        zhuyan.setText("主演："+str);

        List<String> arr=movieDetailBean.getGenres();
        StringBuilder strr=new StringBuilder();
        for (i = 0; i <arr.size() ; i++) {
            if (i==arr.size()-1){
                strr.append(arr.get(i));
            }else {
                strr.append(arr.get(i));
                strr.append(",");
            }
            type.setText("类型："+strr);
        }

        List<String> arrr=movieDetailBean.getAka();
        StringBuilder strrr=new StringBuilder();
        for (i = 0; i <arr.size() ; i++) {
            if (i==arr.size()-1){
                strrr.append(arrr.get(i));
            }else {
                strrr.append(arrr.get(i));
                strrr.append(",");
            }
            moviename.setText("又名："+strr);
        }
        if (arrr.size()==0){
            moviename.setVisibility(View.GONE);
        }
        List<String> arrCountry=movieDetailBean.getCountries();
        StringBuilder strrCountry=new StringBuilder();
        for ( i = 0; i <arrCountry.size() ; i++) {
            if (i==arrCountry.size()-1){
                strrCountry.append(arrCountry.get(i));
            }else {
                strrCountry.append(arrCountry.get(i));
                strrCountry.append(",");
            }
            country.setText("制片国家/地区："+strrCountry);
        }
        time.setText("上映日期："+movieDetailBean.getYear()+"年");
        star.setText("评分："+movieDetailBean.getRating().getAverage()+"分"+"        ⊙"+movieDetailBean.getRatings_count()+"人参与评分");
    }

    @Override
    public void resultFailure(String result) {
//        popBackStack();
//        Toast.makeText(MyApplication.getContext(), "发生未知错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public MoviePresenter createPresenter() {
        return new MoviePresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
