package com.fengwenyi.result;

import com.fengwenyi.javalib.util.Console;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <类说明>
 * <p>
 * <功能详细描述>
 *
 * @author Wenyi Feng
 * @since 2018-09-02
 */
public class Parser {

    public static void main(String[] args) {
        String jsonStr = "\n" +
                "{\"code\":0,\"msg\":null,\"data\":[{\"name\":\"冯文议\",\"age\":26,\"gender\":\"男\"},{\"name\":\"张三\",\"age\":25,\"gender\":\"女\"},{\"name\":\"李四\",\"age\":23,\"gender\":\"保密\"},{\"name\":\"王五\",\"age\":20,\"gender\":\"未知\"}],\"success\":true}";

        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();

        Boolean success = jsonObject.get("success").getAsBoolean();

        // Exception in thread "main" java.lang.UnsupportedOperationException: JsonNull
        //String msg = jsonObject.get("msg").getAsString();

        String msg = jsonObject.get("msg").toString();
        Console.info(success);
        Console.info(msg);
    }
}
