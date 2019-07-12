package com.shinhoandroid.testhotupdata;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String TAG = "lpf";

    File apk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.tv)).setText(new Title().getTitle());

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将asset文件夹文件读到内存中
                setAssetFileToCache(MainActivity.this);
            }
        });

         apk = new File(getCacheDir() + "/hotfix.dex");

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apk.exists()) {
                    apk.delete();
                }
            }
        });
    }

    public void setAssetFileToCache(Activity context){

        try {
            InputStream is = getAssets().open("hotfix.dex");

            FileOutputStream fos = new FileOutputStream(apk);


            byte[] mByte = new byte[1024];

            int bt = 0;

            while ((bt = is.read(mByte))!=-1){
                fos.write(mByte,0,bt);
            }
            Log.e(TAG,"文件写入成功");
            fos.flush(); //刷新缓冲区
            is.close();  //关闭读取流
            fos.close(); // 关闭写入流

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,e.getMessage());
        }

    }


}
