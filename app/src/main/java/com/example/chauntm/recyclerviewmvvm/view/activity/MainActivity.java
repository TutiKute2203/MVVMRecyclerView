package com.example.chauntm.recyclerviewmvvm.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.chauntm.recyclerviewmvvm.R;
import com.example.chauntm.recyclerviewmvvm.model.User;
import com.example.chauntm.recyclerviewmvvm.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 4/20/2016.
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

	@Bind(R.id.recycler_user)
	RecyclerView mRecyclerView;

	@Bind(R.id.swipe_container)
	SwipeRefreshLayout mSwipeRefreshLayout;

	private List<User> mUsers;
	private MyAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		setUpData();
		setupRecyclerView();
		mSwipeRefreshLayout.setOnRefreshListener(this);
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

	private void setupRecyclerView() {
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setHasFixedSize(true);
		mAdapter = new MyAdapter(this, mUsers);
		mRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public void onRefresh() {
		mUsers.clear();
		mUsers.add(new User("Hue1"));
		mUsers.add(new User("Hang1"));
		mUsers.add(new User("Hong1"));
		mUsers.add(new User("Cuc1"));
		mUsers.add(new User("Lan1"));
		mUsers.add(new User("Sen1"));
		mUsers.add(new User("Ly1"));
	}

}
