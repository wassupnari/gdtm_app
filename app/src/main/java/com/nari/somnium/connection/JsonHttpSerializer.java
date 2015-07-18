package com.nari.somnium.connection;

import com.google.gson.Gson;


public class JsonHttpSerializer implements HttpSerializer {
    private Gson mapper = new Gson();

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public String serialize(Object object) {
        return mapper.toJson(object);
    }

    @Override
    public Object deserialize(String value, Class type) {
        return mapper.fromJson(value, type);
    }
}
