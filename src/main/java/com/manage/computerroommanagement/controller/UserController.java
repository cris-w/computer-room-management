package com.manage.computerroommanagement.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manage.computerroommanagement.entity.Bo.UserBo;
import com.manage.computerroommanagement.entity.Users;
import com.manage.computerroommanagement.service.UsersService;
import com.manage.computerroommanagement.utils.R;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/2/22 1:44 PM
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UsersService usersService;

    /**
     * 登录
     *
     * @param user userBo
     * @return ok
     */
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

    /**
     * 创建角色(管理员端)
     *
     * @param user user
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Users user) {
        if(usersService.isExist(user.getUsername())) {
            return R.error("用户名已存在");
        }
        usersService.save(user);
        return R.success("创建成功");
    }

    /**
     * 通过id删除角色
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/delete/{id}")
    public R<Void> delete(@PathVariable Long id) {
        usersService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取用户信息
     *
     * @param id id
     * @return user
     */
    @GetMapping("/getById/{id}")
    public R<Users> getById(@PathVariable Long id) {
        Users user = usersService.getById(id);
        return R.success(user);
    }

    /**
     * 查询所有用户信息
     *
     * @return users
     */
    @GetMapping("/list")
    public R<List<Users>> list(String username) {
        List<Users> users = usersService.list(
                new LambdaQueryWrapper<Users>().like(StrUtil.isNotBlank(username),
                        Users::getUsername, username));
        return R.success(users);
    }

    /**
     * 通过id修改用户信息
     *
     * @param users users
     * @return user
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Users users) {
        String oldName = usersService.getById(users.getId()).getUsername();
        if (!oldName.equals(users.getUsername()) && usersService.isExist(users.getUsername())) {
            return R.error("用户名已存在");
        }
        usersService.updateById(users);
        return R.success("修改成功");
    }

}
