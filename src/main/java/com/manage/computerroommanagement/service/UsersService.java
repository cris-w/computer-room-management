package com.manage.computerroommanagement.service;

import com.manage.computerroommanagement.entity.Bo.UserBo;
import com.manage.computerroommanagement.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wjh
* @description 针对表【users(用户表)】的数据库操作Service
* @createDate 2022-02-22 13:42:25
*/
public interface UsersService extends IService<Users> {

    /**
     * 登录校验
     *
     * @param user userBo
     * @return true 登录成功 false 登录失败
     */
    Boolean login(UserBo user);


    /**
     * 判断用户表中是否存在该用户
     *
     * @param username 用户名
     * @return true 存在 false 不存在
     */
    boolean isExist(String username);
}
