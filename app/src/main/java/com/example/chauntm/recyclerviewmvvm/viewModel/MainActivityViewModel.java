package com.example.chauntm.recyclerviewmvvm.viewModel;

import android.content.Context;

import com.example.chauntm.recyclerviewmvvm.model.User;
import com.example.chauntm.recyclerviewmvvm.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chauntm on 4/27/2016.
 */
public class MainActivityViewModel {
	private List<User> mUsers;
	private MyAdapter mAdapter;
	private Context context;

	public MainActivityViewModel(Context context) {
		setUpData();
		this.context = context;
	}

	private void setUpData() {
		mUsers = new ArrayList<>();
		mUsers.add(new User("Hue"));
		mUsers.add(new User("Hang"));
		mUsers.add(new User("Hong"));
		mUsers.add(new User("Cuc"));
		mUsers.add(new User("Lan"));
		mUsers.add(new User("Sen"));
		mUsers.add(new User("Ly"));
	}

	public void setupRecyclerView() {
		mAdapter = new MyAdapter(this.context, mUsers);
	}

	public MyAdapter getAdapter() {
		return mAdapter;
	}
}
