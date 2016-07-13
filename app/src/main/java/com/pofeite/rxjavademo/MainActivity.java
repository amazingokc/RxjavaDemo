package com.pofeite.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView txtinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtinfo = (TextView) findViewById(R.id.txt_info);
//        rx.Observable<String> myObservable = rx.Observable.create(
//                new rx.Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> sub) {
//                        sub.onNext("Hello, world!");
//                        sub.onCompleted();
//                    }
//                }
//        );

        myObservable.subscribe(mySubscriber);

    }

    rx.Observable<String> myObservable = rx.Observable.just("hello world")
            .subscribeOn(Schedulers.io())                //后台线程取数据，主线程显示
            .observeOn(AndroidSchedulers.mainThread());

    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
//                System.out.println(s);
            txtinfo.setText("_" + s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCompleted() {
            Log.d("onCompleted", "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d("onError", "onError");
        }
    };

}
