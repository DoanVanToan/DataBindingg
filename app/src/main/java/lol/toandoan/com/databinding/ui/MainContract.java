package lol.toandoan.com.databinding.ui;

import android.view.View;

import lol.toandoan.com.databinding.model.User;

/**
 * Created by ToanDoan on 2/7/2017.
 */

public interface MainContract {
    interface View {
        void showUser(User user);
        void setProgress(boolean isShow);
    }

    interface Presenter {
        void fakeUser(android.view.View view);
    }
}
