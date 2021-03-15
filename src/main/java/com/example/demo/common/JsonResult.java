package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

public class JsonResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private JsonResult() {
    }

    public static JsonResult ok() {
        return ok("SUCCESS");
    }

    public static JsonResult ok(String message) {
        return ok(1, message);
    }

    public static JsonResult ok(int status, String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("status", status);
        jsonResult.put("msg", message);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        jsonResult.put("result", resultMap);

        return jsonResult;
    }

    public static JsonResult error() {
        return error("FAIL");
    }

    public static JsonResult error(String messag) {
        return error(0, messag);
    }

    public static JsonResult error(int status, String message) {
        return ok(status, message);
    }

    public JsonResult setStatus(int status) {
        super.put("status", status);
        return this;
    }

    public JsonResult setMessage(String message) {
        super.put("msg", message);
        return this;
    }

    public JsonResult setResult(Object object) {
        if (null != object) {
            super.put("result", object);
        }
        return this;
    }

    @Override
    public JsonResult put(String key, Object object) {
        super.put(key, object);
        return this;
    }

}