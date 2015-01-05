package com.jingliang.androidhttp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.jingliang.androidhttp.asynchttp.AsyncHttpActivity;
import com.jingliang.androidhttp.xutil.XutilsActivity;

public class MainActivity extends Activity {

	private Intent mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button_asynchttp).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mIntent = new Intent(MainActivity.this,
								AsyncHttpActivity.class);
						startActivity(mIntent);
					}
				});

		findViewById(R.id.button_xutils).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mIntent = new Intent(MainActivity.this,
								XutilsActivity.class);
						startActivity(mIntent);
					}
				});
	}

}
