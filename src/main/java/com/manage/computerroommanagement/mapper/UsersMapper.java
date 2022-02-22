package com.manage.computerroommanagement.mapper;

import com.manage.computerroommanagement.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author wjh
* @description 针对表【users(用户表)】的数据库操作Mapper
* @createDate 2022-02-22 13:42:25
* @Entity generator.domain.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 通过用户名名密码查询 用户
     *
     * @param username username
     * @param password pwd
     * @return user
     */
    Users selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}




