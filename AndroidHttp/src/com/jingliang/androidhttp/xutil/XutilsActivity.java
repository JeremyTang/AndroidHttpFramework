package com.jingliang.androidhttp.xutil;

import com.jingliang.androidhttp.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class XutilsActivity extends Activity {

	private static final String URL = "http://www.baidu.com";
	private HttpUtils mHttp;

	private TextView xUtilText;
	private ProgressBar xUtilProgress;

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xutils);

		xUtilText = (TextView) findViewById(R.id.text_xutils);
		xUtilProgress = (ProgressBar) findViewById(R.id.progress_xutils);
		xUtilProgress.setVisibility(View.VISIBLE);

		mHttp = new HttpUtils(10000);
		mHttp.send(HttpMethod.GET, URL, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				progressDismiss();
				showFailure();
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				// TODO Auto-generated method stub
				xUtilText.setText(arg0.result);
				progressDismiss();
			}
		});
	};

	private void progressDismiss() {
		xUtilProgress.setVisibility(View.GONE);
	}

	private void showFailure() {
		Toast.makeText(this, "Request Failure!", Toast.LENGTH_SHORT).show();
	}

}
