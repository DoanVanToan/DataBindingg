package lol.toandoan.com.databinding.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lol.toandoan.com.databinding.R;
import lol.toandoan.com.databinding.databinding.ActivityMainBinding;
import lol.toandoan.com.databinding.model.User;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter mPresenter;
    private ActivityMainBinding mBinding;
    private User mUser;
    private MainAdapter mAdapter;
    private List<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mUser = new User(1, "Test", "User", "");
        mBinding.setUser(mUser);
        mBinding.setPresenter(mPresenter);
        mUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            mUsers.add(new User(i, "Toan Doan " + i, "Toan Doan " + i,
                "http://anhnendep.net/wp-content/uploads/2016/03/anh-girl-xinh-hot-girl-han-quoc-05.jpg"));
        mAdapter = new MainAdapter(this, mUsers, mPresenter);
        mBinding.setAdapter(mAdapter);
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
