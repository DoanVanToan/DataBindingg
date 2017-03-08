package lol.toandoan.com.databinding.test;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

import lol.toandoan.com.databinding.BR;

/**
 * Created by framgia on 08/03/2017.
 */
public class TestModel extends BaseObservable implements Serializable {
    private String mName;

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }
}
