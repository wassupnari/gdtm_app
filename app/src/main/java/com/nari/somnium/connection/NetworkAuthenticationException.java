package com.nari.somnium.connection;

public class NetworkAuthenticationException extends HttpAppException {
    public NetworkAuthenticationException() {
        super("Network authentication required", NetworkError.AuthenticationRequired);
    }

}
