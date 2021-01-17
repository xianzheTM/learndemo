package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.Vo.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xianzheTM
 * @date 2021/1/16 21:45
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> userListRouterFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/users2/list"),
            request -> {
                // 查询列表
                List<UserVO> result = new ArrayList<>();
                result.add(UserVO.builder().id(1).username("aa").build());
                result.add(UserVO.builder().id(2).username("bb").build());
                result.add(UserVO.builder().id(3).username("cc").build());
                // 返回列表
                return ServerResponse.ok().bodyValue(result);
            });
    }

    @Bean
    public RouterFunction<ServerResponse> userGetRouterFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/users2/get"),
            request -> {
                // 获得编号
                Integer id = request.queryParam("id")
                    .map(s -> StringUtils.hasText(s) ? null : Integer.valueOf(s)).get();
                // 查询用户
                UserVO user = UserVO.builder().id(3).username(UUID.randomUUID().toString()).build();
                // 返回列表
                return ServerResponse.ok().bodyValue(user);
            });
    }


}
