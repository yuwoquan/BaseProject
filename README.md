
# BaseProject




```
*2019-2-17
#### 打算用于所有快速项目中的基类,以便快速使用开发
所有的自定义控件写在utils包下面，res/layout/weight用于存放自定义控件的布局文件
```
####自定义控件来源
```
nicepinner:  * https://github.com/arcadefire/nice-spinner
customdatepicker *https://github.com/liuwan1992/CustomDatePicker
tagCloudView *https://github.com/kingideayou/TagCloudView
```
```
<com.example.baseproject.util.weight.NineImageView
    android:id="@+id/photo"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    android:layout_marginLeft="4dp"
    android:layout_marginRight="4dp"
    android:layout_marginBottom="10dp"
    app:nineImageHorizontalSpace="4dp"
    app:nineImageRatio="0.9"
    app:nineImageVerticalSpace="4dp"/>
    
     nineImageView.setImageUrls(list,MyApplication.getContext());
            nineImageView.setOnClickItemListener(new NineImageView.OnClickItemListener() {
                @Override
                public void onClick(int i, ArrayList<String> url) {
                   
                }
            });
```