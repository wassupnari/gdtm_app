package com.nari.somnium.connection;

import android.content.Context;
import android.net.ConnectivityManager;

public class HttpFactory {
	public static Http create(Context context) {
        return new HttpUrlConnection(new JsonHttpSerializer(),
                new NetworkImpl((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)));
    }
}