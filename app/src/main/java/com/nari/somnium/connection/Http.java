package com.nari.somnium.connection;


public interface Http {
	public HttpRequest get(String url);
    public HttpRequest post(String url);
    public HttpRequest put(String url);
    public HttpRequest delete(String url);
    public HttpRequest request(String url, String method);
}
