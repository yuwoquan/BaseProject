package com.example.baseproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.baseproject.MainActivity;
import com.example.baseproject.utils.utils.ShareUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @author Ambrose
 * @date 2019/1/17 7:24 PM
 * @desc
 */
public class WelcomeActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.timer(0, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (ShareUtils.getString(ShareUtils.USER_HEAD_URI, "") != "") {
                            Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
//                            Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
//                            startActivity(intent);
//                            finish();
                        }
                    }
                });
    }

}
