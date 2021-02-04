/**
 * Created with JackHou
 * Date: 2021/2/4
 * Time: 15:23
 * Description:
 */

package com.qtimes.mvvm.ui.view;

import android.content.Context;
import android.util.Log;

import javax.security.auth.callback.Callback;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: JackHou
 * Date: 2021/2/4.
 */
public class ShakeListener implements LifecycleObserver {

    private static final String TAG = "ShakeListener";

    public ShakeListener(Context context) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.d(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.d(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(TAG, "onDestroy");
    }
}
