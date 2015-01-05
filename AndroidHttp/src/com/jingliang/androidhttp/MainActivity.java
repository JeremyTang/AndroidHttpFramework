package com.jingliang.androidhttp;

import com.jingliang.androidhttp.asynchttp.AsyncHttpActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

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
	}

}
