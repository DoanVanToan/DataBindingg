package lol.toandoan.com.databinding.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lol.toandoan.com.databinding.databinding.FragmentNumberBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {
    private static final String ARGUMENT_USER = "ARGUMENT_USER";
    private TestModel mTestModel;
    private FragmentNumberBinding mBinding;

    public NumberFragment() {
        // Required empty public constructor
    }

    public static NumberFragment newInstance(TestModel testModel) {
        NumberFragment fragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGUMENT_USER, testModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentNumberBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) mTestModel = (TestModel) bundle.getSerializable(ARGUMENT_USER);
        mBinding.setTest(mTestModel);
    }


}
