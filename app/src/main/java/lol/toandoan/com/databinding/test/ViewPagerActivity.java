package lol.toandoan.com.databinding.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import lol.toandoan.com.databinding.R;
import lol.toandoan.com.databinding.databinding.ActivityViewPagerBinding;

public class ViewPagerActivity extends AppCompatActivity {
    private TestModel mTestModel;
    private ActivityViewPagerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager);
        mTestModel = new TestModel();
        mTestModel.setName("Doan Van Toan");
        mBinding.viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mBinding.setActivity(this);

    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private NumberFragment mFirst = NumberFragment.newInstance(mTestModel);
        private NumberFragment mSecond = NumberFragment.newInstance(mTestModel);
        private NumberFragment mThird = NumberFragment.newInstance(mTestModel);

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mFirst;
                case 1:
                    return mSecond;
                case 2:
                    return mThird;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public void onClick() {
        mTestModel.setName("ABC");
        Log.d("a", "onClick: ");
    }
}
