package com.fengwenyi.javalibexampleaoplog;

import com.fengwenyi.javalib.aop.LBaseWebLogAspect;
import com.fengwenyi.javalib.result.DefaultReturnCode;
import com.fengwenyi.javalib.result.Result;
import com.fengwenyi.javalib.result.ResultResponseUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavalibExampleAoplogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavalibExampleAoplogApplication.class, args);
    }

    /**
     * 获取所有用户数据
     * @return (json)
     */
    @GetMapping("/getUsers")
    public Result getUsers() {

        User user1 = new User().setName("冯文议").setAge(26).setGender("男");
        User user2 = new User().setName("张三").setAge(25).setGender("女");
        User user3 = new User().setName("李四").setAge(23).setGender("保密");
        User user4 = new User().setName("王五").setAge(20).setGender("未知");

        User [] users = {user1, user2, user3, user4};

        return ResultResponseUtil.ok().status(DefaultReturnCode.SUCCESS).data(users);

    }
}

@Aspect
@Component
class WebLogAspect extends LBaseWebLogAspect {

    @Pointcut("execution(* com.fengwenyi.javalibexampleaoplog..*.*(..))")
    @Override
    protected void pointCut() { }
}

@Data
@Accessors(chain = true)
class User {

    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private String gender;

}
