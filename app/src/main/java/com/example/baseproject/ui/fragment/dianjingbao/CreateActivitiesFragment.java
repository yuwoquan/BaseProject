package com.example.baseproject.ui.fragment.dianjingbao;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.db.MyReleaseBean;
import com.example.baseproject.db.MyReleaseController;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.activity.LoginActivity;
import com.example.baseproject.utils.utils.RxPhotoTool;
import com.example.baseproject.utils.utils.pick_time.DateAdapter;
import com.example.baseproject.utils.utils.pick_time.DateUtils;
import com.example.baseproject.utils.utils.pick_time.TimeAdapter;
import com.example.baseproject.utils.weight.DialogChooseImage;
import com.qmuiteam.qmui.arch.QMUIFragmentActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class CreateActivitiesFragment extends BaseFragment {


    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.input_title) EditText inputTitle;
    @BindView(R.id.time) TextView time;
    @BindView(R.id.input_address) EditText inputAddress;
    @BindView(R.id.input_numberr) EditText inputNumberr;
    @BindView(R.id.imageview) ImageView imageview;
    @BindView(R.id.signout) QMUIRoundButton signout;
    private Uri resultUri;
    private MyReleaseController myReleaseController;
    private DateAdapter mRVLeftAdapter;
    private TimeAdapter mRVRightAdapter;
    private static String[] strList = new String[]{"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
            "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
    private static List<String> leftData;
    private static List<String> rightData;
    private  MyHandler mHandler;
    String select_time,select_date;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_create_activities, null);
        ButterKnife.bind(this, view);
        myReleaseController=new MyReleaseController();
        setTopbar(mtopbar, "创建活动");
        /**
         * 初始化获取今天的时间的设置信息
         */
        String strAA = DateUtils.get7date().get(0) + DateUtils.get7week().get(0);
        select_date = strAA.substring(5, 10);
        mHandler = new MyHandler((QMUIFragmentActivity) getActivity());
        /**
         * 初始化时间选择数据列表信息
         */
        Observable.timer(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        leftData = new ArrayList<>();
                        for (int i = 0; i < 30; i++) {
                            String str = DateUtils.get7date().get(i) + DateUtils.get7week().get(i);
                            leftData.add(str.substring(5, 10) + "\n" + str.substring(10, 12));
                        }
                        rightData = new ArrayList<>();
                        for (int i = 0; i < strList.length; i++) {
                            rightData.add(strList[i]);
                        }
                    }
                });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerTimeDialog();
            }
        });
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialogChooseImage();
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputTitle.getText().toString())){
                    Toast.makeText(MyApplication.getContext(), "标题不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(time.getText().toString())){
                    Toast.makeText(MyApplication.getContext(), "活动日期不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputAddress.getText().toString())){
                    Toast.makeText(MyApplication.getContext(), "活动地址不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputNumberr.getText().toString())){
                    Toast.makeText(MyApplication.getContext(), "报名人数不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (resultUri == null) {
                    Toast.makeText(MyApplication.getContext(), "请上传头像", Toast.LENGTH_SHORT).show();
                    return;
                }
                myReleaseController.insert(new MyReleaseBean(null,String.valueOf(resultUri),inputTitle.getText().toString(),time.getText().toString(),inputAddress.getText().toString(),inputNumberr.getText().toString(),null));
                popBackStack();
                Toast.makeText(MyApplication.getContext(), "发布成功", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void pickerTimeDialog() {
//        HideSoftKeyBoardDialog(getActivity());
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme).create();
        View view = View.inflate(getActivity(), R.layout.picker_time_dialog, null);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        //window.setWindowAnimations(R.style.dialogStyle);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        //设置dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        window.setContentView(view);
        //获得window窗口的属性
        WindowManager.LayoutParams params = window.getAttributes();
        //设置窗口宽度为充满全屏
        //如果不设置,可能部分机型出现左右有空隙,也就是产生margin的感觉
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        // 获取屏幕宽、高用
        DisplayMetrics d = MyApplication.getContext().getResources().getDisplayMetrics();
        params.height = (int) (d.heightPixels * 0.65);
//        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;//显示dialog的时候,就显示软键盘
        //这个属性导致window后所有的东西都成暗淡
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        //设置对话框的透明程度背景(非布局的透明度)
        params.dimAmount = 0.5f;
        window.setAttributes(params);
        RecyclerView mRvLeft = view.findViewById(R.id.rv_left);
        RecyclerView mRvRight = view.findViewById(R.id.rv_right);
        QMUITopBar mTopBar = view.findViewById(R.id.mtopbar);
        mTopBar.setTitle("选择时间");
        mTopBar.addRightImageButton(R.mipmap.dialog_close, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        //取消设置分割线
        mTopBar.setBackgroundDividerEnabled(false);

        mRvLeft.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));

        mRvLeft.setAdapter(mRVLeftAdapter = new DateAdapter(leftData));
        mRVLeftAdapter.setOnLeftItemClickListener(new DateAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {
                select_date = mRVLeftAdapter.getData().get(position);
            }
        });
        //右边的recycleview
        mRvRight.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        mRvRight.setAdapter(mRVRightAdapter = new TimeAdapter(rightData));
        mRVRightAdapter.setOnLeftItemClickListener(new TimeAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {
                select_time = mRVRightAdapter.getData().get(position);
                dialog.dismiss();
                String endSureTime =select_date.substring(0, 5) + " " + select_time;
//                Long eTime = getTimeOut(endSureTime);
//                timeMsg.setText("你所选择的时间戳："+eTime+"\n"+endSureTime);
                time.setText(endSureTime.toString());
            }
        });

    }
    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }
    /**
     * 日期转换时间戳
     *
     * @param longtime
     * @return
     */
    public static long getTimeOut(String longtime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(longtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime() / 1000;
    }
    private void initDialogChooseImage() {
        DialogChooseImage dialogChooseImage = new DialogChooseImage(this);
        dialogChooseImage.show();
    }

    private void initUCrop(Uri uri) {

        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));
        /**
         * 后台服务器无法识别jpeg的图片。设置jpg才上传成功，
         */
        Uri destinationUri = Uri.fromFile(new File(getActivity().getCacheDir(), imageName + ".jpg"));
        UCrop.Options options = new UCrop.Options();
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        options.setToolbarColor(ActivityCompat.getColor(getActivity(), R.color.cam));
        options.setStatusBarColor(ActivityCompat.getColor(getActivity(), R.color.camtwo));
        options.setMaxScaleMultiplier(5);
        options.setImageToCropBoundsAnimDuration(666);
        options.setCircleDimmedLayer(false);
        options.setShowCropFrame(false);
        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(500, 200)
                .withOptions(options)
                .start(getActivity(), UCrop.REQUEST_CROP);
    }


    //接收返回的地址
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoTool.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoTool.cropImage(ActivityUser.this, );// 裁剪图片
//                    initUCrop(data.getData());
                    resultUri=data.getData();
                    Glide.with(this).
                            load(data.getData()).
                            thumbnail(0.5f).
                            into(imageview);
                }
                break;
            case RxPhotoTool.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
                    /* data.getExtras().get("data");*/
//                    RxPhotoTool.cropImage(ActivityUser.this, RxPhotoTool.imageUriFromCamera);// 裁剪图片
//                    initUCrop(RxPhotoTool.imageUriFromCamera);
                    resultUri=data.getData();
                    Glide.with(this).
                            load(data.getData()).
                            thumbnail(0.5f).
                            into(imageview);
                }

                break;
            case RxPhotoTool.CROP_IMAGE://普通裁剪后的处理
//                RequestOptions options = new RequestOptions()
//                        .placeholder(R.drawable.circle_elves_ball)
//                        //异常占位图(当加载异常的时候出现的图片)
//                        .error(R.drawable.circle_elves_ball)
//                        //禁止Glide硬盘缓存缓存
//                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

                Glide.with(this).
                        load(RxPhotoTool.cropImageUri).
                        thumbnail(0.5f).
                        into(imageview);
//                RequestUpdateAvatar(new File(RxPhotoTool.getRealFilePath(mContext, RxPhotoTool.cropImageUri)));
                break;

            case UCrop.REQUEST_CROP://UCrop裁剪之后的处理
                if (resultCode == RESULT_OK) {
                    resultUri = UCrop.getOutput(data);
                    Glide.with(this).load(resultUri).into(imageview);
//                    roadImageView(resultUri, image);
//                    RxSPTool.putContent(mContext, "AVATAR", resultUri.toString());
//                    String filePath = resultUri.getPath().toString().trim();
//                    File file = new File(filePath);
//                    filePath = file.getAbsolutePath();
//                    Log.e(TAG, "文件地址：" + filePath + "-----" + file.getName());
//                    File   file = new File(Environment.getExternalStorageDirectory(),uri.toString());

                } else if (resultCode == UCrop.RESULT_ERROR) {
                    final Throwable cropError = UCrop.getError(data);
                }
                break;
            case UCrop.RESULT_ERROR://UCrop裁剪错误之后的处理
                final Throwable cropError = UCrop.getError(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private static class MyHandler extends Handler {

        private WeakReference<QMUIFragmentActivity> activityWeakReference;

        public MyHandler(QMUIFragmentActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            QMUIFragmentActivity activity = activityWeakReference.get();
            if (activity != null) {
                if (msg.what == 1) {
//                    leftData = new ArrayList<>();
//                    for (int i = 0; i < 30; i++) {
//                        String str = DateUtils.get7date().get(i) + DateUtils.get7week().get(i);
//                        leftData.add(str.substring(5, 10) + "\n" + str.substring(10, 12));
//                    }
//                    rightData = new ArrayList<>();
//                    for (int i = 0; i < strList.length; i++) {
//                        rightData.add(strList[i]);
//                    }
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
