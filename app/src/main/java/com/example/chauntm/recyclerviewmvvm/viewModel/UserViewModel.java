package com.example.chauntm.recyclerviewmvvm.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.example.chauntm.recyclerviewmvvm.model.User;

/**
 * Created by Administrator on 4/23/2016.
 */
public class UserViewModel extends BaseObservable {

	private Context context;
	private User user;

	public UserViewModel(Context context, User user) {
		this.context = context;
		this.user = user;
	}

	public String getName() {
		return user.getName();
	}

}
