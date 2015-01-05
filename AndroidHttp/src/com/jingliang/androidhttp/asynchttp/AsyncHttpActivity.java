package com.jingliang.androidhttp.asynchttp;

import org.apache.http.Header;
import org.json.JSONArray;

import com.jingliang.androidhttp.R;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author tjl
 *
 */
public class AsyncHttpActivity extends Activity {

	private static final String URL = "http://www.baidu.com";
	private TextView resultText;
	private ProgressBar requestProgress;

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynchttp);

		resultText = (TextView) findViewById(R.id.text_result);
		requestProgress = (ProgressBar) findViewById(R.id.progress_request);

		AsyncHttpUtil.getHttpClient().get(URL, new MyTextHandler());
		requestProgress.setVisibility(View.VISIBLE);
	};

	private void progressDismiss() {
		requestProgress.setVisibility(View.GONE);
	}

	private void showFailure() {
		Toast.makeText(this, "Request Failure!", Toast.LENGTH_SHORT).show();
	}

	class MyResponHandler extends AsyncHttpResponseHandler {

		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			// TODO Auto-generated method stub
			try {
				String str = new String(arg2);
				resultText.setText(str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressDismiss();
			showFailure();
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			// TODO Auto-generated method stub

			progressDismiss();
		}

	}

	class MyTextHandler extends TextHttpResponseHandler {

		@Override
		public void onFailure(int arg0, Header[] arg1, String arg2,
				Throwable arg3) {
			// TODO Auto-generated method stub

			progressDismiss();
			showFailure();
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, String arg2) {
			// TODO Auto-generated method stub
			resultText.setText(arg2);

			progressDismiss();
		}

	}

	class MyJsonHandler extends JsonHttpResponseHandler {
		@Override
		public void onSuccess(int statusCode, Header[] headers,
				JSONArray response) {
			// TODO Auto-generated method stub
			super.onSuccess(statusCode, headers, response);
			progressDismiss();
		}

		@Override
		public void onFailure(int statusCode, Header[] headers,
				String responseString, Throwable throwable) {
			// TODO Auto-generated method stub
			super.onFailure(statusCode, headers, responseString, throwable);
			progressDismiss();
			showFailure();
		}
	}
}
