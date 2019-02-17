package com.example.baseproject.utils.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * @author Ambrose
 * @date 2018/12/8 10:51 AM
 * @desc
 */
public class CheckPrs {

    public static  Boolean isHave(Activity context){
        PackageManager pm = context.getPackageManager();
        boolean flag = (PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", "com.example.westernjourney"));
        if (!flag){
            showMessageNegativeDialog(context);
        }
        return flag;
    }
    private static void showMessageNegativeDialog(final Activity context) {
        int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("提示")
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .setMessage("检测到未开启读写手机存储权限，是否要跳转到权限页面开启权限？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(context, "暂未开启读写手机存储权限，无法保存图片。", Toast.LENGTH_SHORT).show();
                    }
                })
                .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package",context.getPackageName(), null);
                        intent.setData(uri);
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }
}
