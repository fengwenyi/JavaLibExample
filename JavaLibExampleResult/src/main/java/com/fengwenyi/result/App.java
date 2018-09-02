package com.fengwenyi.result;

import com.fengwenyi.javalib.result.DefaultReturnCode;
import com.fengwenyi.javalib.result.Result;
import com.fengwenyi.javalib.result.ResultResponseUtil;
import com.fengwenyi.javalib.util.Console;
import com.google.gson.Gson;

/**
 * <类说明>
 * <p>
 * <功能详细描述>
 *
 * @author Wenyi Feng
 * @since 2018-09-02
 */
public class App {

    public static void main(String[] args) {

        // 成功，无数据，自定义返回码和描述
        Result result1 = ResultResponseUtil.ok().code(0).msg("Success");
        // 成功，返回数据，自定义返回码和描述
        Result result2 = ResultResponseUtil.ok().code(0).msg("Success").data("data");
        // 成功，无数据，通过enum方式存放返回码
        Result result3 = ResultResponseUtil.ok().status(DefaultReturnCode.SUCCESS);
        // 成功，返回数据，通过enum方式存放返回码
        Result result4 = ResultResponseUtil.ok().status(DefaultReturnCode.SUCCESS).data("data");

        // 失败，无数据，自定义返回码和描述
        Result result5 = ResultResponseUtil.error().code(-1).msg("Error");
        // 失败，返回数据，自定义返回码和描述
        Result result6 = ResultResponseUtil.error().code(-1).msg("Error").data("data");
        // 失败，无数据，通过enum方式存放返回码
        Result result7 = ResultResponseUtil.error().status(DefaultReturnCode.ERROR_INIT);
        // 失败，返回数据，通过enum方式存放返回码
        Result result8 = ResultResponseUtil.error().status(DefaultReturnCode.ERROR_INIT).data("data");

        Console.info(result1);
        Console.info(result2);
        Console.info(result3);
        Console.info(result4);
        Console.info(result5);
        Console.info(result6);
        Console.info(result7);
        Console.info(result8);
        Console.info();
        Console.info(new Gson().toJson(result1));
        Console.info(new Gson().toJson(result2));
        Console.info(new Gson().toJson(result3));
        Console.info(new Gson().toJson(result4));
        Console.info(new Gson().toJson(result5));
        Console.info(new Gson().toJson(result6));
        Console.info(new Gson().toJson(result7));
        Console.info(new Gson().toJson(result8));
    }
}
