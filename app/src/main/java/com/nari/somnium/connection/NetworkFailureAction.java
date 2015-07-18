package com.nari.somnium.connection;

public class NetworkFailureAction implements Action {
    private HttpRequestResponseHandler handler;
    private NetworkError error;

    public NetworkFailureAction(HttpRequestResponseHandler handler, NetworkError error) {
        this.handler = handler;
        this.error = error;
    }

    @Override
    public void call() {
        handler.failure(error);
    }

}
