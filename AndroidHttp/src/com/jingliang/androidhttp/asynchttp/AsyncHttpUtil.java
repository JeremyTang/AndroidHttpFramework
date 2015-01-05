package com.jingliang.androidhttp.asynchttp;

import com.loopj.android.http.AsyncHttpClient;

/**
 * 
 * @author tjl
 *
 */
public class AsyncHttpUtil {

	private static final int TIMEOUT = 10000;
	private static AsyncHttpClient mHttpClient = null;

	static {
		mHttpClient = new AsyncHttpClient();
		mHttpClient.setTimeout(TIMEOUT);
	}

	public static AsyncHttpClient getHttpClient() {
		return mHttpClient;
	}

	public static void setHttpTimeout(int timeout) {
		mHttpClient.setTimeout(timeout);
	}

}
