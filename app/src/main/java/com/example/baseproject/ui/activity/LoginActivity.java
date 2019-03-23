package com.example.baseproject.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.example.baseproject.MainActivity;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.utils.utils.PermissionManager;
import com.example.baseproject.utils.utils.RxPhotoTool;
import com.example.baseproject.utils.utils.ShareUtils;
import com.example.baseproject.utils.weight.DialogChooseImage;
import com.example.baseproject.utils.weight.datePicker.CustomDatePicker;
import com.example.baseproject.utils.weight.datePicker.DateFormatUtils;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.link_login) TextView linkLogin;
    @BindView(R.id.tv_selected_date) TextView mTvSelectedDate;
    @BindView(R.id.ll_date) LinearLayout llDate;
    @BindView(R.id.input_xingzuo) EditText inputXingzuo;
    @BindView(R.id.input_home) EditText inputHome;
    @BindView(R.id.input_school) EditText inputSchool;
    private Uri resultUri;
    @BindView(R.id.imagebg)
    ImageView imagebg;
    @BindView(R.id.hea)
    CircleImageView hea;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.btn_signup)
    QMUIRoundButton btnSignup;
    private CustomDatePicker mDatePicker;
    //    @BindView(R.id.topbar) QMUITopBar qmuiTopBar;
    private static final String TAG = "LoginActivity";
    @BindView(R.id.fragout) FrameLayout fragout;
    protected static final int REQUEST_APP_PERMISSION = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);
        calculateGradeCount();
        initView();
        QMUIViewHelper.fadeIn(imagebg, 2000, null, true);
        MultiTransformation multi = new MultiTransformation(new ColorFilterTransformation(0x35000000), new BlurTransformation(5, 15));
        Glide.with(MyApplication.getContext())
                .load(R.drawable.minebg)
                .apply(RequestOptions.bitmapTransform(multi))
                .into(imagebg);
        initDatePicker();
//        Glide.with(this).load(R.drawable.minebg).into(imagebg);
    }

    /**
     * 计算评分人数
     */
    private void calculateGradeCount() {
        long lastTime = ShareUtils.getLong(ShareUtils.USER_OPEN_APP_TIME, System.currentTimeMillis() / 1000);
        ShareUtils.putLong(ShareUtils.USER_OPEN_APP_TIME, System.currentTimeMillis() / 1000);

        Date lastDate = new Date(lastTime);
        Date curDate = new Date(System.currentTimeMillis() / 1000);

        ShareUtils.putLong(ShareUtils.USER_USE_DURATION, ShareUtils.getLong(ShareUtils.USER_USE_DURATION, 0) + curDate.getTime() - lastDate.getTime());
    }

    private void initView() {

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击提交
                if (resultUri == null) {
                    Toast.makeText(LoginActivity.this, "请上传头像", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputName.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请填写昵称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputXingzuo.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请填写星座", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputHome.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请填写家乡", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputSchool.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请填写学校", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputPassword.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请填写个性签名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mTvSelectedDate.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请出生日期", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                // 存储用户名和头像
                ShareUtils.putString(ShareUtils.USER_NICKNAME,inputName.getText().toString());
                ShareUtils.putString(ShareUtils.ANA_ONE_RES,inputXingzuo.getText().toString());
                ShareUtils.putString(ShareUtils.ANY_TWO_RES,inputHome.getText().toString());
                ShareUtils.putString(ShareUtils.ANY_THREE_RES,inputSchool.getText().toString());
                ShareUtils.putString(ShareUtils.GRADE_USER_INDEX,inputPassword.getText().toString());
                ShareUtils.putString(ShareUtils.GRADE_USER_INDEXX,mTvSelectedDate.getText().toString());
                ShareUtils.putString(ShareUtils.USER_HEAD_URI, String.valueOf(resultUri));
                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        });
        hea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击头像
                initDialogChooseImage();
            }
        });
    }

    private void initDialogChooseImage() {
        DialogChooseImage dialogChooseImage = new DialogChooseImage(this);
        dialogChooseImage.show();
    }

    private void initDatePicker() {
        long beginTimestamp = DateFormatUtils.str2Long("2009-05-01", false);
        long endTimestamp = System.currentTimeMillis();

        mTvSelectedDate.setText(DateFormatUtils.long2Str(endTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mTvSelectedDate.setText(DateFormatUtils.long2Str(timestamp, false));
            }
        }, beginTimestamp, endTimestamp);
        // 不允许点击屏幕或物理返回键关闭
        mDatePicker.setCancelable(false);
        // 不显示时和分
        mDatePicker.setCanShowPreciseTime(false);
        // 不允许循环滚动
        mDatePicker.setScrollLoop(false);
        // 不允许滚动动画
        mDatePicker.setCanShowAnim(false);
        mTvSelectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePicker.show(mTvSelectedDate.getText().toString());
            }
        });
    }

    private void initUCrop(Uri uri) {

        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));
        /**
         * 后台服务器无法识别jpeg的图片。设置jpg才上传成功，
         */
        Uri destinationUri = Uri.fromFile(new File(getCacheDir(), imageName + ".jpg"));
        UCrop.Options options = new UCrop.Options();
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        options.setToolbarColor(ActivityCompat.getColor(this, R.color.cam));
        options.setStatusBarColor(ActivityCompat.getColor(this, R.color.camtwo));
        options.setMaxScaleMultiplier(5);
        options.setImageToCropBoundsAnimDuration(666);
        options.setCircleDimmedLayer(true);
        options.setShowCropFrame(false);
        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(500, 500)
                .withOptions(options)
                .start(this, UCrop.REQUEST_CROP);
    }


    //接收返回的地址
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoTool.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoTool.cropImage(ActivityUser.this, );// 裁剪图片
                    initUCrop(data.getData());
                }
                break;
            case RxPhotoTool.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
                    /* data.getExtras().get("data");*/
//                    RxPhotoTool.cropImage(ActivityUser.this, RxPhotoTool.imageUriFromCamera);// 裁剪图片
                    initUCrop(RxPhotoTool.imageUriFromCamera);
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
                        into(hea);
//                RequestUpdateAvatar(new File(RxPhotoTool.getRealFilePath(mContext, RxPhotoTool.cropImageUri)));
                break;

            case UCrop.REQUEST_CROP://UCrop裁剪之后的处理
                if (resultCode == RESULT_OK) {
                    resultUri = UCrop.getOutput(data);
                    Glide.with(this).load(resultUri).into(hea);
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

    @Override
    protected void onResume() {
        super.onResume();
        PermissionManager.getInstance().checkPermission(this, REQUEST_APP_PERMISSION);
    }
}
