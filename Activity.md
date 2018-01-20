Four components——Activity、Service、Content Provider、Broadcast Receiver

### Activity的生命周期
![image](http://hi.csdn.net/attachment/201109/1/0_1314838777He6C.gif)

1.启动Activity：系统会先调用onCreate方法，然后调用onStart方法，最后调用onResume，Activity进入运行状态。

2.当前Activity被其他Activity覆盖其上或被锁屏：系统会调用onPause方法，暂停当前Activity的执行。

3.当前Activity由被覆盖状态回到前台或解锁屏：系统会调用onResume方法，再次进入运行状态。

4.当前Activity转到新的Activity界面或按Home键回到主屏，自身退居后台：系统会先调用onPause方法，然后调用onStop方法，进入停滞状态。

5.用户后退回到此Activity：系统会先调用onRestart方法，然后调用onStart方法，最后调用onResume方法，再次进入运行状态。

6.当前Activity处于被覆盖状态或者后台不可见状态，即第2步和第4步，系统内存不足，杀死当前Activity，而后用户退回当前Activity：再次调用onCreate方法、onStart方法、onResume方法，进入运行状态。

7.用户退出当前Activity：系统先调用onPause方法，然后调用onStop方法，最后调用onDestory方法，结束当前Activity。

    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
          
        Log.i(TAG, "onCreate");  
    }  
    @Override  
    protected void onStart() {  
        Log.i(TAG, "onStart");  
        super.onStart();  
    }  
    @Override  
    protected void onRestart() {  
        Log.i(TAG, "onRestart");  
        super.onRestart();  
    }  
    @Override  
    protected void onResume() {  
        Log.i(TAG, "onResume");  
        super.onResume();  
    }  
    @Override  
    protected void onPause() {  
        Log.i(TAG, "onPause");  
        super.onPause();  
    }  
    @Override  
    protected void onStop() {  
        Log.i(TAG, "onStop");  
        super.onStop();  
    }  
    @Override  
    protected void onDestroy() {  
        Log.i(TAG, "onDestroy");  
        super.onDestroy();  
    }
    
    
    

---
#### app/src/main/Java/MainActivity:

    package com.example.ucla.helloworld;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private EditText editText;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("HITMSC");
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                String string = editText.getText().toString();

                if (string.equals("Android")){
                    string = "Welcome";
                }
                else if (string.equals("toast")){
                    Toast.makeText(MainActivity.this,"This is a toast",Toast.LENGTH_SHORT).show();
                }
                textView.setText(string);
                return true;
            }
        });
    }
    

---
#### app/src/main/res/layout/activity_main

    <?xml version="1.0" encoding="utf-8"?>

    <LinearLayout android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:weightSum="1">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="30dp"
        android:orientation="vertical"
        android:layout_gravity="center">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/textView"
                android:textSize="50dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="LOOK"/>

            <ImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:background="@drawable/pic"/>

        </LinearLayout>

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Button"
            android:layout_gravity="center"/>

    </LinearLayout>

        <EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:hint="Click here to edit"
            android:layout_margin="20dp"/>

    </LinearLayout>
