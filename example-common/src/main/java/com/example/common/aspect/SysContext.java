package com.example.common.aspect;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class SysContext {

    public static final ThreadLocal<Map<String,Object>> contextData = new ThreadLocal<>();
    
    public static final String USER = "user";

    public static final String USER_ID = "userId";

    public static final String MOBILE = "mobile";
    
    public static final String VERSION = "version";

    public static String getUser() {
        return getStringValue(USER);
    }
    public static void putUser(String value) {
        contextData.get().put(USER, value);
        parseJson(value);
    }

    public static Long getUserId() {
    	return getLongValue(USER_ID);
    }
    public static void putUserId(Object value) {
        contextData.get().put(USER_ID, value);
    }
    
    public static String getMobile() {
    	return getStringValue(MOBILE);
    }
    public static void putMobile(Object value) {
        contextData.get().put(MOBILE, value);
    }
    
    public static String getVersion() {
        return getStringValue(VERSION);
    }
    public static void putVersion(Object value) {
        contextData.get().put(VERSION, value);
    }
    
    public static void init() {
    	contextData.set(new HashMap<String, Object>());
    }
    
    public static void remove() {
    	contextData.remove();
    }
    
    
    private static Long getLongValue(String key) {
    	if(contextData.get() == null) return null;
    	Object value = contextData.get().get(key);
    	if(value == null) {
    		return null;
    	}
    	return (Long)value;
    }
    
    private static String getStringValue(String key) {
    	if(contextData.get() == null) return null;
    	Object value = contextData.get().get(key);
    	if(value == null) {
    		return null;
    	}
    	
    	return (String)value;
    }

    public static void parseJson(String jsonStr) {
        try {
            jsonStr = jsonStr.replace("\\", "");
            jsonStr= jsonStr.substring(1, jsonStr.length()-1);
            SysUser sysUser;
            try{
                sysUser = JSON.parseObject(jsonStr, SysUser.class);
                putUserId(sysUser.getId());
                putMobile(sysUser.getMobile());
                } catch (Exception ex){
                    putUserId(0L);
                    putMobile("13888888888");
                }
        } catch (Exception e) {
            System.out.println("header里x-user解析错误：x-user=" + jsonStr + e.getMessage());
        }
    }

    
}
