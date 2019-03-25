package com.example.baseproject.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.ThreeAdapter;
import com.example.baseproject.adapter.ZhuBoAdapter;
import com.example.baseproject.db.GreenDaoManager;
import com.example.baseproject.db.ZhuboBean;
import com.example.baseproject.db.ZhuboBeanDao;
import com.example.baseproject.db.ZhuboController;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.decorator.GridDividerItemDecoration;
import com.example.baseproject.utils.weight.spinner.NiceSpinner;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhuboFragment extends BaseFragment {


    @BindView(R.id.et_search) EditText etSearch;
    @BindView(R.id.card_view) LinearLayout cardView;
    @BindView(R.id.tv_search) TextView tvSearch;
    @BindView(R.id.layout_author) RelativeLayout layoutAuthor;
    @BindView(R.id.nice_spinnerone) NiceSpinner niceSpinnerone;
    @BindView(R.id.nice_spinnertwo) NiceSpinner niceSpinnertwo;
    @BindView(R.id.nice_spinnerthree) NiceSpinner niceSpinnerthree;
    @BindView(R.id.appbar) QMUIAppBarLayout appbar;
    @BindView(R.id.recyclerviewtwo) RecyclerView recyclerviewtwo;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.btn) FloatingActionButton btn;
    @BindView(R.id.sp) LinearLayout sp;
    private List<String> stringList = new ArrayList<>();
    private ZhuboController zhuboController;
    private ZhuBoAdapter zhuBoAdapter;
    private List<ZhuboBean> zhuboBeans = new ArrayList<>();
    private List<ZhuboBean> homeKD;
    private View errorView;
    private String[] tvs = new String[]{"熊猫"};
    private String sone, stwo, sthree;
    private static final String TAG = "TwoFragment";
    private int al = 0;
    private int cl = 0;
    private int bl = 100;
    private int dl = 10000000;
    private int youshi = 0;
    private List<ZhuboBean> fensiBean = new ArrayList<>();
    private ThreeAdapter threeAdapter;
    @Override
    protected View onCreateView() {
        CoordinatorLayout layout = (CoordinatorLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_three, null);
        ButterKnife.bind(this, layout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerview.setVisibility(View.GONE);
                recyclerviewtwo.setVisibility(View.VISIBLE);
                etSearch.getText().clear();
                niceSpinnerone.setVisibility(View.GONE);
                niceSpinnertwo.setVisibility(View.GONE);
                niceSpinnerthree.setVisibility(View.GONE);
            }
        });
        homeKD = GreenDaoManager.getInstance().getSession().getZhuboBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(ZhuboBeanDao.Properties.Id)
                .build()
                .list();
        Log.e(TAG, "onCreateView: "+homeKD.size() );
        fensiBean.add(homeKD.get(getRandNum(1,30)));
        fensiBean.add(homeKD.get(getRandNum(31,60)));
        fensiBean.add(homeKD.get(getRandNum(61,90)));
        fensiBean.add(homeKD.get(getRandNum(91,120)));
        fensiBean.add(homeKD.get(getRandNum(121,140)));
        View viewhead = getLayoutInflater().inflate(R.layout.head, (ViewGroup)recyclerviewtwo.getParent(), false);
        threeAdapter = new ThreeAdapter(fensiBean);
        threeAdapter.addHeaderView(viewhead);
        StaggeredGridLayoutManager staggeredGridLayoutManagerr = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerviewtwo.setLayoutManager(staggeredGridLayoutManagerr);
        recyclerviewtwo.setAdapter(threeAdapter);
        threeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String a=threeAdapter.getData().get(position).getXingzuo();
                String key=null;
                if (a.equals("熊猫直播")){
                    key="NbFCpC8qITVtLSsWeu39uGNhTKQkjhAU";
                }else if (a.equals("抱抱直播")){
                    key="NI3mKy86_c1mAy2vzvs7SR7BcWkBD86Z";
                }else if (a.equals("斗鱼直播")){
                    key="Hdwh6iIFE3bezvFgCmX-uvoyXd5WVFi_";
                }else if (a.equals("虎牙直播")){
                    key="kPgvfpT-sR72UkO0TINVgIv_kJxNrX6a";
                }else if (a.equals("花椒直播")){
                    key="5BjsJqPIo7XphmfaGGKmxhosAtDJZfn5";
                }else if (a.equals("火山小视频")){
                    key="zf5VD34nyKkYnXe22SjQ-0Gg83Wy0r00";
                }else if (a.equals("快手短视频")){
                    key="F45kpLkyvz3vrtjcN2tEA5L-qfzvMidX";
                }else if (a.equals("企鹅电竞")){
                    key="ng34eegTk3iupNLKGsX1hZer8zdSm1d1";
                }else if (a.equals("一直播")){
                    key="gSkJw2G54BV60unvjBx9huPb5MFJmPPL";
                }else if (a.equals("映客直播")){
                    key="qCiuHBGhLTQHazmSnyd-rP0stEwBVxlG";
                }
                joinQQGroup(key);
            }
        });
        threeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ZhuboDetailFragment zhuboDetailFragment = new ZhuboDetailFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("k",threeAdapter.getData().get(position));
//                zhuboDetailFragment.setArguments(bundle);
//                startFragment(zhuboDetailFragment);
            }
        });

        List<String> dataset = new LinkedList<>(Arrays.asList("不限年龄", "18-22岁", "23-25岁", "25岁+"));
        List<String> datasett = new LinkedList<>(Arrays.asList("不限粉丝数", "1-10w", "10-30w", "30W+"));
        List<String> datasettt = new LinkedList<>(Arrays.asList("不限优势", "高颜值", "好才艺", "搞笑达人"));
        niceSpinnerone.attachDataSource(dataset);
        niceSpinnertwo.attachDataSource(datasett);
        niceSpinnerthree.attachDataSource(datasettt);
        niceSpinnerone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        al = 0;
                        bl = 100;
                        break;
                    case 1:
                        al = 18;
                        bl = 22;
                        break;
                    case 2:
                        al = 23;
                        bl = 25;
                        break;
                    case 3:
                        al = 25;
                        bl = 100;
                        break;
                    default:
                        break;
                }
                fillter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        niceSpinnertwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        cl = 0;
                        dl = 100000000;
                        break;
                    case 1:
                        cl = 1;
                        dl = 100000;
                        break;
                    case 2:
                        cl = 100000;
                        dl = 300000;
                        break;
                    case 3:
                        cl = 300000;
                        dl = 100000000;
                        break;
                    default:
                        break;
                }
                fillter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        niceSpinnerthree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                youshi = position;
                fillter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        zhuboController = ZhuboController.getInstance();
        zhuBoAdapter = new ZhuBoAdapter(zhuboBeans);
        recyclerview.addItemDecoration(new GridDividerItemDecoration(MyApplication.getContext(), 1));
        errorView = getLayoutInflater().inflate(R.layout.empty, (ViewGroup) recyclerview.getParent(), false);
        zhuBoAdapter.setEmptyView(errorView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        recyclerview.setAdapter(zhuBoAdapter);
        zhuBoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ZhuboDetailFragment zhuboDetailFragment = new ZhuboDetailFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("k", zhuBoAdapter.getData().get(position));
//                zhuboDetailFragment.setArguments(bundle);
//                startFragment(zhuboDetailFragment);
            }
        });
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
//                    getPresenter().clickRequestResult(etSearch.getText().toString());

                    //此处搜索
                }

                return false;
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(MyApplication.getContext(), "搜索内容不能为空。", Toast.LENGTH_SHORT).show();
                    return;
                }
                closeKeyboard();
                recyclerview.setVisibility(View.VISIBLE);
                recyclerviewtwo.setVisibility(View.GONE);
                niceSpinnerone.setVisibility(View.VISIBLE);
                niceSpinnertwo.setVisibility(View.VISIBLE);
                niceSpinnerthree.setVisibility(View.VISIBLE);
//                layoutSearch.setVisibility(View.GONE);
                fillter();
            }
        });
        return layout;
    }
    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }

    private void fillter() {
        zhuBoAdapter.getData().clear();
        if (zhuboController.likeQuery(etSearch.getText().toString().trim()).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQuery(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryID(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }
            return;
        }
        if (zhuboController.likeQueryID(etSearch.getText().toString().trim()).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQueryID(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }
            return;
        }
        if (zhuboController.likeQueryName(etSearch.getText().toString().trim()).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }
            return;
        }
    }

    private void searck(String textpp){
//        layoutSearch.setVisibility(View.GONE);
        recyclerview.setVisibility(View.VISIBLE);
        etSearch.setText(textpp);
        etSearch.setSelection(textpp.length());

        if (zhuboController.likeQuery(textpp).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQuery(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryID(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            Log.e(TAG, "onTagClickaaaa: " + size);
            Log.e(TAG, "onTagClick: " + al + "--" + bl + "--" + cl + "--" + dl + "===");
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }
            return;
        }
        if (zhuboController.likeQueryID(textpp).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQueryID(etSearch.getText().toString()));
            zhuBoAdapter.addData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }

            return;
        }
        if (zhuboController.likeQueryName(textpp).size() != 0) {
            zhuBoAdapter.setNewData(zhuboController.likeQueryName(etSearch.getText().toString()));
            int size = zhuBoAdapter.getData().size();
            for (int i = size - 1; i >= 0; i--) {
                switch (youshi) {
                    case 0:
                        if (zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {
                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: !!!!" + i);
                        }

                        break;
                    case 1:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("高颜值")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: @@@" + i);
                        }

                        break;
                    case 2:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("好才艺")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: ####" + i);
                        }

                        break;
                    case 3:
                        if (zhuBoAdapter.getData().get(i).getYanzhi().equals("搞笑达人")
                                && zhuBoAdapter.getData().get(i).getSe() >= al
                                && zhuBoAdapter.getData().get(i).getSe() <= bl
                                && zhuBoAdapter.getData().get(i).getLeveal() >= cl
                                && zhuBoAdapter.getData().get(i).getLeveal() <= dl) {

                        } else {
                            zhuBoAdapter.getData().remove(i);
                            zhuBoAdapter.notifyItemRemoved(i);
                            Log.e(TAG, "onTagClick: $$$" + i);
                        }

                        break;
                    default:
                        break;
                }
            }
            return;
        }
        closeKeyboard();
    }

    public boolean joinQQGroup(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            Toast.makeText(MyApplication.getContext(), "你的手机暂未安装手机QQ。无法跳转。", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void closeKeyboard() {
        View view = getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
