package com.manage.computerroommanagement.entity.Bo;

import lombok.Data;

/**
 * 用于接受用户登录传递的数据
 * username & password
 *
 * @author wjh
 * @date 2022/2/22 1:53 PM
 */
@Data
public class UserBo {

    private String username;
    private String password;
}
