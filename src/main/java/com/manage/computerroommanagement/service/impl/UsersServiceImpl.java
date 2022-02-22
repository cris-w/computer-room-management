package com.manage.computerroommanagement.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.Bo.UserBo;
import com.manage.computerroommanagement.entity.Users;
import com.manage.computerroommanagement.exception.MyException;
import com.manage.computerroommanagement.service.UsersService;
import com.manage.computerroommanagement.mapper.UsersMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author wjh
 * @description 针对表【users(用户表)】的数据库操作Service实现
 * @createDate 2022-02-22 13:42:25
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public Boolean login(UserBo user) {
        boolean exist = this.isExist(user.getUsername());
        if (!exist) {
            throw new MyException(404, "用户不存在");
        }
        return usersMapper.selectByUsernameAndPassword(user.getUsername(),
                user.getPassword()) != null;
    }

    @Override
    public boolean isExist(String username) {
        return usersMapper.selectCount(
                new LambdaQueryWrapper<Users>().eq(Users::getUsername, username)) > 0;
    }
}




