package com.ekito.novela2012;

import x.lib.AsyncHttpClient;
import x.lib.AsyncHttpResponse;
import android.app.Activity;

public class APIManager {
	
	private static final String API_URL = "http://novela2012.ekito.fr";
	

	private final Activity mContext;
	private AsyncHttpClient client;

	public APIManager(Activity context)
	{
		this.mContext = context;
	}

	private AsyncHttpResponse createStandardResponse(final AsyncHttpResponse response)
	{
		return new AsyncHttpResponse()
		{
			@Override public void onBytesProcessed(int amountProcessed, int totalSize)
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onBytesProcessed(amountProcessed, totalSize);
			}

			@Override public void beforeFinish()
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.beforeFinish();
			}

			@Override public void onBytesProcessed(byte[] chunk, int amountProcessed, int totalSize)
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onBytesProcessed(chunk, amountProcessed, totalSize);
			}

			@Override public void onFailure(int responseCode, String responseMessage)
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onFailure(responseCode, responseMessage);
			}

			@Override public void onFinish()
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onFinish();
			}

			@Override public void onSend()
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onSend();
			}

			@Override public void onSuccess(byte[] r)
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onSuccess(r);
			}

			@Override public void onSuccess(Object r)
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onSuccess(r);
			}

			@Override public void onFailure()
			{
				if (response == null) return;
				response.setConnectionInfo(getConnectionInfo());
				response.onFailure();
			}
		};
	}
	
	public void cancel()
	{
		client.cancel();
	}
	
	public String getMapURL()
	{
		return API_URL;
	}
}
