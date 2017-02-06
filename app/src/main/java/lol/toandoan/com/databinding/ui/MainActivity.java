package lol.toandoan.com.databinding.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lol.toandoan.com.databinding.R;
import lol.toandoan.com.databinding.databinding.ActivityMainBinding;
import lol.toandoan.com.databinding.model.User;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter mPresenter;
    private ActivityMainBinding mBinding;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mUser = new User(1, "Test", "User");
        mBinding.setUser(mUser);
        mBinding.setPresenter(mPresenter);

    }

    @Override
    public void showUser(User user) {
        mUser.setFirstName(user.getFirstName());
        mUser.setLastName(user.getLastName());
        mUser.setId(user.getId());
    }

    @Override
    public void setProgress(boolean isShow) {
        mBinding.setIsShowProgress(isShow);
    }
}
