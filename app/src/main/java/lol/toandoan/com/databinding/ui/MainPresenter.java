package lol.toandoan.com.databinding.ui;

import android.view.View;

import java.util.Random;

import lol.toandoan.com.databinding.model.User;

/**
 * Created by ToanDoan on 2/7/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void fakeUser(android.view.View view) {
        int id = new Random().nextInt();
        User user = new User(id, "Toan", "Doan");
        mView.showUser(user);
        if (id % 2 == 0) {
            mView.setProgress(true);
        } else {
            mView.setProgress(false);
        }
    }
}
