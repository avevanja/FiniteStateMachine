package com.example.aveva.fsmalarm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.aveva.fsmalarm.presenters.MainPresenter;
import com.example.aveva.fsmalarm.views.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    private Button mButtonLock, mButtonUnLock, mButtonLockx2, mButtonUnLockx2;
    private Switch mSwitch;
    private MainPresenter mMainPresenter;
    private TextView mTextView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonLock = (Button) findViewById(R.id.button_lock);
        mButtonUnLock = (Button) findViewById(R.id.button_unlock);
        mButtonLockx2 = (Button) findViewById(R.id.button_lockx2);
        mButtonUnLockx2 = (Button) findViewById(R.id.button_unlockx2);
        mSwitch = (Switch) findViewById(R.id.switch_show_alarm);
        mTextView = (TextView) findViewById(R.id.tv_state);
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.getFsm();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case (R.id.button_lock):
                        mMainPresenter.Lock();
                        break;
                    case (R.id.button_unlock):
                        mMainPresenter.UnLock();
                        break;
                    case (R.id.button_lockx2):
                        mMainPresenter.Lockx2();
                        break;
                    case (R.id.button_unlockx2):
                        mMainPresenter.UnLockx2();
                        break;

                }
            }
        };
        mButtonLock.setOnClickListener(listener);
        mButtonUnLock.setOnClickListener(listener);
        mButtonLockx2.setOnClickListener(listener);
        mButtonUnLockx2.setOnClickListener(listener);


    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void isArmed(boolean isArmed, String state) {
        mSwitch.setChecked(isArmed);
        mTextView.setText(state);
        if (isArmed)
           mTextView.setTextColor(getResources().getColor(R.color.colorTextArmed));
        else {
            mTextView.setTextColor(getResources().getColor(R.color.colorTextDisarmed));
        }


    }
}
