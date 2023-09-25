package com.pbl.app_mobile.network;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class JsonHandle {
    public static String GetValue(Key key, Response<ResponseBody> response){
        JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
        switch (key){
            case success:
                return jsonObject.get("success").toString();
            default:
                return null;
        }
    }
}
