/**
 * Created with JackHou
 * Date: 2021/2/4
 * Time: 14:06
 * Description:
 */

package com.qtimes.mvvm.ui.state;

import android.os.SystemClock;
import android.util.Log;

import com.qtimes.mvvm.data.bean.TimeBean;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: JackHou
 * Date: 2021/2/4.
 */
public class TimerViewModel extends ViewModel {

    private static final String TAG = "TimerViewModel";
    private MutableLiveData<TimeBean> mLiveDataTime = new MutableLiveData<>();
    private long mInitialTime;

    public TimerViewModel() {
        Log.d(TAG, "TimerViewModel constructor");
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                mLiveDataTime.postValue(new TimeBean("当前时间: " + newValue));
            }
        }, 0, 1000);
    }

    public MutableLiveData<TimeBean> getLiveDataTime() {
        return mLiveDataTime;
    }
}
