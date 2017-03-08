package lol.toandoan.com.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ToanDoan on 2/7/2017.
 */
public class User<T> extends BaseObservable {
    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mAvatar;
    private T data;

    public User(int id, String firstName, String lastName, String avatar) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mAvatar = avatar;
    }


    public void setId(int id) {
        mId = id;
        notifyChange();
    }

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
        notifyChange();
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
        notifyChange();
    }

    public int getId() {
        return mId;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        this.mAvatar = avatar;
    }
}
