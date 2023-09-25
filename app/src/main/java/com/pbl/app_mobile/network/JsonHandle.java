package com.pbl.app_mobile.network;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class JsonHandle {
    private static Object GetValue(Key key, Response<ResponseBody> response){
        try {
            String responseBody = response.body().string();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> responseMap = gson.fromJson(responseBody, type);
            return responseMap.get(key.toString());
        } catch (Exception e){}
        return "";
    }
    private static Object GetValue(Key key, Response<ResponseBody> response,boolean isError){
        try {
            String responseBody = isError ? response.errorBody().string() : response.body().string();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> responseMap = gson.fromJson(responseBody, type);
            return responseMap.get(key.toString());
        } catch (Exception e){}
        return "";
    }
    public static boolean IsSuccess(Response<ResponseBody> response){
        return (boolean) GetValue(Key.success,response);
    }
    public static boolean IsSuccess(Response<ResponseBody> response,boolean isError){
        return (boolean) GetValue(Key.success,response,isError);
    }
    public static String getMessage(Response<ResponseBody> response,boolean isError){
        return (String) GetValue(Key.message,response,isError);
    }
}
