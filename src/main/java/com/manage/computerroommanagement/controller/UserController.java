package com.manage.computerroommanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manage.computerroommanagement.entity.Bo.UserBo;
import com.manage.computerroommanagement.entity.Users;
import com.manage.computerroommanagement.service.UsersService;
import com.manage.computerroommanagement.utils.R;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/2/22 1:44 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    public R<String> login(@RequestBody UserBo user) {
        Boolean is = usersService.login(user);
        if (is) {
            return R.success("登录成功", user.getUsername());
        }
        return R.error("用户名密码错误", null);
    }

    /**
     * 获取用户信息
     *
     * @param token username
     * @return user
     */
    @GetMapping("/userInfo")
    public R<Users> userInfo(String token) {
        Users user = usersService.getOne(
                new LambdaQueryWrapper<Users>().eq(Users::getUsername, token));
        return R.success(user);
    }

}
