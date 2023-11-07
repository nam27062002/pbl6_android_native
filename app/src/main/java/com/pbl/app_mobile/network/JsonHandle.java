package com.pbl.app_mobile.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class JsonHandle {
    public static String responseBody = "";
    private static Object GetValue(Key key, Response<ResponseBody> response){
        try {
            responseBody = response.body().string();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> responseMap = gson.fromJson(responseBody, type);
            JSONObject jsonObject = new JSONObject(responseBody);
            return responseMap.get(key.toString());
        } catch (Exception e){}
        return "";
    }
    private static Object GetValue(Key key, Response<ResponseBody> response,boolean isError){
        try {
            responseBody = isError ? response.errorBody().string() : response.body().string();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> responseMap = gson.fromJson(responseBody, type);
            return responseMap.get(key.toString());
        } catch (Exception e){}
        return "";
    }
    public static boolean IsSuccess(Response<ResponseBody> response){
        if ((boolean) GetValue(Key.success,response)){
            return true;
        }
        return false;

    }
    public static String GetId(){
        try {
            JSONObject jsonObject = new JSONObject(responseBody);
            return jsonObject.getJSONObject("data").getJSONObject("user").getString("id");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String GetAccessToken(){
        try {
            JSONObject jsonObject = new JSONObject(responseBody);
            return jsonObject.getJSONObject("data").getJSONObject("user").getString("accessToken");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean IsSuccess(Response<ResponseBody> response,boolean isError){
        return (boolean) GetValue(Key.success,response,isError);
    }
    public static String getMessage(Response<ResponseBody> response,boolean isError){
        return (String) GetValue(Key.message,response,isError);
    }
}
