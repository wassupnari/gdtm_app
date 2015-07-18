package com.nari.somnium.connection;

public class HttpAppException extends Exception {
    private NetworkError error;

    public HttpAppException(String message, NetworkError error) {
        super(message);
        this.error = error;
    }

    public NetworkError getNetworkError() {
        return error;
    }

}
