package com.nari.somnium.connection;

import org.apache.http.HttpResponse;

public class HttpRequestResponseHandler<T> {
	public void success(T data, HttpDataResponse response){}
    public void error(String message, HttpDataResponse response){}
    public void failure(NetworkError error){}
    public void complete(){}
}
