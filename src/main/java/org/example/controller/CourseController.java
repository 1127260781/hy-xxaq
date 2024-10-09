package org.example.controller;

import com.auth0.jwt.JWT;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Result;
import org.example.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/course")
public class CourseController {
    @GetMapping("/get")
    public Result<String> list(/*@RequestHeader(name="jwtoken") String token , HttpServletResponse response*/){
//        try {
//            Map<String,Object> claims = JwtUtil.parseToken(token);
//            return Result.success("jwt测试");
//        } catch (Exception e){
//            response.setStatus(401);
//            return Result.error("登录状态失效(token错误)");
//        }
        return Result.success("jwt测试 成功0");
    }
}
