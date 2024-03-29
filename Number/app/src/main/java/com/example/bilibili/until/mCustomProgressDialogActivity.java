package com.example.bilibili.until;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilibili.R;

public class mCustomProgressDialogActivity extends ProgressDialog {

    private AnimationDrawable mAnimation;       //设置对话框动画资源
    private  Context mContent;                  //设置对话框上下文
    private ImageView mImageView;               //设置对话框背景图片
    private String mLoadingTip;                 //设置对话框文字
    private TextView mLoadingTv;                //设置对话框文字
    private int mResid;                         //设置对话框动画资源的id

    public mCustomProgressDialogActivity(Context context,String content, int themeResId) {
        super( context, themeResId);
        this.mContent = context;        //为上下文赋值
        this.mLoadingTip = content;             //为对话框文字赋值
        this.mResid = themeResId;               //为动画资源id赋值
        //设置单击周边是否让dialog消失，设置为true 点击周边消失
        setCanceledOnTouchOutside(true);
    }       //自定义对话框构造方法尾部

    //自定义对话框构造方法头部
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        //获取布局文件中TextView组件
        mLoadingTv = findViewById(R.id.loadingTv);
        //获取布局文件中ImageView组件
        mImageView = findViewById(R.id.loadingIv);
        if (mResid == 0){                   //当资源id为0时
            mImageView.setBackgroundResource(0);        //设置背景为空
        }else {
            mImageView.setBackgroundResource(mResid);       //否则设置指定动画资源id
        }
        //通过ImageView对象拿到背景显示的动画资源文件
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        //为了防止在onCreate方法中只显示第一帧的解决方案之一
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                //动画开始
                mAnimation.start();
            }
        });
        //设置显示文字
        mLoadingTv.setText(mLoadingTip);
    }   //创建的onCreate方法尾部
}       //自定义对话框尾部
