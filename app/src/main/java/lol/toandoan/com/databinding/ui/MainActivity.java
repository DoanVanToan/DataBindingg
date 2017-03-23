package lol.toandoan.com.databinding.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ObservableField<String> mSpinner = new ObservableField<>();

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

        mSpinner.set("C");
        CharSequence[] itemArray =
            getResources().getTextArray(R.array.spinner);
        List<CharSequence> itemList =
            new ArrayList<CharSequence>(Arrays.asList(itemArray));
        ArrayAdapter adapter = new ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            itemList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mBinding.setAdapter(adapter);
        mBinding.setSpinner(mSpinner.get());
    }

    @Override
    public void showUser(User user) {
        mUser.setFirstName(user.getFirstName());
        mUser.setLastName(user.getLastName());
        mUser.setId(user.getId());
    }

    public ObservableField<String> getSpinner() {
        return mSpinner;
    }

    @Override
    public void setProgress(boolean isShow) {
        mBinding.setIsShowProgress(isShow);
    }
}
