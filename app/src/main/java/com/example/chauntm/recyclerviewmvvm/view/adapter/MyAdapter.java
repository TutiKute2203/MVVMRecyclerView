package com.example.chauntm.recyclerviewmvvm.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chauntm.recyclerviewmvvm.R;
import com.example.chauntm.recyclerviewmvvm.databinding.ItemHeaderBinding;
import com.example.chauntm.recyclerviewmvvm.databinding.ItemUserBinding;
import com.example.chauntm.recyclerviewmvvm.model.Header;
import com.example.chauntm.recyclerviewmvvm.model.User;
import com.example.chauntm.recyclerviewmvvm.viewModel.HeaderViewModel;
import com.example.chauntm.recyclerviewmvvm.viewModel.UserViewModel;

import java.util.List;

/**
 * Created by Administrator on 4/20/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BindingHolder>{

	private static final int VIEW_TYPE_USER = 0;
	private static final int VIEW_TYPE_HEADER = 1;

	private Context mContext;
	private List<User> mUsers;

	public MyAdapter(Context context, List<User> users) {
		mContext = context;
		mUsers = users;
	}

	@Override
	public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (viewType == VIEW_TYPE_USER) {
			ItemUserBinding userBinding = DataBindingUtil.inflate(
					LayoutInflater.from(parent.getContext()),
					R.layout.item_user,
					parent,
					false);
			return new BindingHolder(userBinding);
		} else {
			ItemHeaderBinding headerBinding = DataBindingUtil.inflate(
					LayoutInflater.from(parent.getContext()),
					R.layout.item_header,
					parent,
					false);
			return new BindingHolder(headerBinding);
		}
	}

	@Override
	public void onBindViewHolder(BindingHolder holder, int position) {
		if (getItemViewType(position) == VIEW_TYPE_USER) {
			ItemUserBinding userBinding = (ItemUserBinding) holder.binding;
			userBinding.setViewModel(new UserViewModel(mContext, mUsers.get(position - 1)));
		} else {
			ItemHeaderBinding headerBinding = (ItemHeaderBinding) holder.binding;
			headerBinding.setViewModel(new HeaderViewModel(mContext, new Header(R.mipmap.ic_launcher)));
		}
	}


	@Override
	public int getItemCount() {
		return mUsers.size() + 1;
	}

	@Override
	public int getItemViewType(int position) {
		// If the post has text, then it's an ASK post - so we show the text as a header comment
		if (position == 0) {
			return VIEW_TYPE_HEADER;
		} else {
			return VIEW_TYPE_USER;
		}
	}

	public static class BindingHolder extends RecyclerView.ViewHolder {
		private ViewDataBinding binding;

		public BindingHolder(ItemUserBinding binding) {
			super(binding.containerItem);
			this.binding = binding;
		}

		public BindingHolder(ItemHeaderBinding binding) {
			super(binding.containerItem);
			this.binding = binding;
		}
	}
}
