package com.qtimes.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.qtimes.mvvm.data.bean.User;
import com.qtimes.mvvm.databinding.ActivityMainBinding;
import com.qtimes.mvvm.ui.state.TimerViewModel;
import com.qtimes.mvvm.ui.state.UserViewModel;
import com.qtimes.mvvm.ui.view.ShakeListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private UserViewModel mUserViewModel;
    private TimerViewModel mTimerViewModel;
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new ShakeListener(this));
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.setLifecycleOwner(this);//建立LiveData和DataBinding双向绑定的关键

        mUserViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(UserViewModel.class);
        mTimerViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(TimerViewModel.class);

        mActivityMainBinding.setUserViewModel(mUserViewModel);
        mActivityMainBinding.setTimeViewModel(mTimerViewModel);

        mActivityMainBinding.setMainEvent(new MainEventHandler());

    }

    public class MainEventHandler {
        public void onClick(View view) {
            int id = -1;
            switch (view.getId()) {
                case R.id.btn_login1:
                    id = 1;
                    break;
                case R.id.btn_login2:
                    id = 2;
                    break;
                default:
                    break;
            }
            mUserViewModel.login(id);
        }
    }
}