package com.example.android.justaid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.baidu.mobstat.StatService;

import java.util.HashMap;
import java.util.Map;

public class WelcomeActivity extends Activity {
    private Connection szsdConnection;
    public static int statusBarHeight;
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private String account;
    private String password;
    private boolean isAutoLog;
    private Handler handlerLogin;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        szsdConnection = Connection.getInstance();

        //添加百度统计
        StatService.start(this);

        activity = this;
        context = this;
        sharedPreferences = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        isAutoLog = sharedPreferences.getBoolean("IS_AUTOLOG", false);
        if (isAutoLog) {
            account = sharedPreferences.getString("ACCOUNT", "");
            password = sharedPreferences.getString("PASSWORD", "");
            sharedPreferences.edit().putBoolean("sameUser", true).commit();
            initHandler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message msg = handlerLogin.obtainMessage();
                    //Map<String, String> infoMap1 = szsdConnection.szsdLogin(account, password, context);

                        msg.arg1 = 2;//登陆成功
                        Map<String, String> infoMap2 = szsdConnection.getLibAndCardInfo();
                        Map<String, String> info = new HashMap<String, String>();
                        info.put("name", "test");
                        info.put("lib", "15");
                        info.put("card", "100");
                        msg.obj = info;

                    handlerLogin.sendMessage(msg);
                }
            }).start();
        } else {
            final Runnable callback = new Runnable() {
                //一段被运行的代码
                @Override
                public void run() {
                    //跳转到新的页面
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);

                    //获取状态栏高度
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    WelcomeActivity.statusBarHeight = rect.top;

                    //增加一个页面跳转的动画
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    //销毁当前的activity
                    finish();
                }
            };
            //实例化消息传递者handler
            final Handler handler = new Handler();
            //在界面停留5秒钟
            Thread thread = new Thread() {
                //当线程运行的时候，执行的操作
                @Override
                public void run() {
                    //在子线程里停留三秒钟
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(callback);
                }
            };
            //开启新的线程
            thread.start();
        }

    }

    private void initHandler() {
        handlerLogin = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println(msg);
                switch (msg.arg1) {
                    case 2:
                        Map<String, String> info = (HashMap<String, String>) msg.obj;
                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        intent.putExtra("name", info.get("name"));
                        intent.putExtra("card", info.get("card"));
                        intent.putExtra("lib", info.get("lib"));
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        WelcomeActivity.this.finish();
                        break;
                    default:
                        //登录失败转到login界面
                        Toast.makeText(context, "登录失败，请重试", Toast.LENGTH_SHORT).show();
                        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        WelcomeActivity.this.finish();
                        break;
                }
            }
        };
    }
}
