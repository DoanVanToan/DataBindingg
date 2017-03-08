package lol.toandoan.com.databinding.ui;

import lol.toandoan.com.databinding.model.User;

/**
 * Created by framgia on 14/02/2017.
 */
public class MainItemHandler {
    private MainContract.Presenter mPresenter;

    public MainItemHandler(MainContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void onClickUser(User user) {
        mPresenter.onClickUser(user);
    }
}
