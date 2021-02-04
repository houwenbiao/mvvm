/**
 * Created with JackHou
 * Date: 2021/2/4
 * Time: 9:49
 * Description:
 */

package com.qtimes.mvvm.ui.state;

import android.app.Application;
import android.util.Log;

import com.qtimes.mvvm.data.bean.User;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Author: JackHou
 * Date: 2021/2/4.
 */
public class UserViewModel extends AndroidViewModel {

    private static final String TAG = "UserViewModel";
    private MutableLiveData<User> mLiveDataUser = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "UserViewModel constructor");
    }

    public void login(int id) {
        //vm倾向于对数据的处理,而不是对于view的处理
        mLiveDataUser.postValue(new User(id == 1 ? "jack" : "喵喵", id + "123456"));
    }

    public MutableLiveData<User> getLiveDataUser() {
        return mLiveDataUser;
    }
}
