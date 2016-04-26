package com.example.chauntm.recyclerviewmvvm.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.graphics.drawable.Drawable;

import com.example.chauntm.recyclerviewmvvm.model.Header;
import com.example.chauntm.recyclerviewmvvm.model.User;

/**
 * Created by Administrator on 4/23/2016.
 */
public class HeaderViewModel extends BaseObservable{

	private Context context;
	private Header header;

	public HeaderViewModel(Context context, Header header) {
		this.context = context;
		this.header = header;
	}

	public Drawable getImageId() {
		return context.getResources().getDrawable(header.getImageId());
	}
}
