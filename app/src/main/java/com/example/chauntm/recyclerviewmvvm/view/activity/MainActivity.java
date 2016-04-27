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
import com.example.chauntm.recyclerviewmvvm.viewModel.MainActivityViewModel;

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

	MainActivityViewModel viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		viewModel = new MainActivityViewModel(this);
		setupRecyclerView();
		mSwipeRefreshLayout.setOnRefreshListener(this);
	}

	private void setupRecyclerView() {
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setHasFixedSize(true);
		viewModel.setupRecyclerView();
		mRecyclerView.setAdapter(viewModel.getAdapter());
	}

	@Override
	public void onRefresh() {
	}

}
