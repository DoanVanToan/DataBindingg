package lol.toandoan.com.databinding.ui;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import lol.toandoan.com.databinding.R;
import lol.toandoan.com.databinding.databinding.ItemUserBinding;
import lol.toandoan.com.databinding.model.User;

/**
 * Created by framgia on 14/02/2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<User> mUsers;
    private LayoutInflater mInflater;
    private MainContract.Presenter mPresenter;

    public MainAdapter(Context context, List<User> users, MainContract.Presenter presenter) {
        mUsers = users;
        mPresenter = presenter;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding mItemBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemBinding = DataBindingUtil.bind(itemView);
        }

        public void bindData(User user) {
            if (user == null) return;
            mItemBinding.setUser(user);
            mItemBinding.setActionHandler(new MainItemHandler(mPresenter));
            mItemBinding.executePendingBindings();
        }
    }

    @BindingAdapter({"bind:imageUrl", "bind:placeHolder"})
    public static void loadImage(ImageView imageView, String url, Drawable placeHolder) {
        Glide.with(imageView.getContext())
            .load(url)
            .placeholder(placeHolder)
            .into(imageView);
    }

    @BindingAdapter({"bind:adapter"})
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
