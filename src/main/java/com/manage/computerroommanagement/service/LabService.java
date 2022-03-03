package com.manage.computerroommanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.computerroommanagement.entity.Lab;

/**
* @author wjh
* @description 针对表【lab(实验室表)】的数据库操作Service
* @createDate 2022-02-25 15:36:28
*/
public interface LabService extends IService<Lab> {

    /**
     * 通过id删除实验室
     * 同步删除预约表关联类容
     *
     * @param id
     * @return
     */
    boolean deleteById(Long id);
}
