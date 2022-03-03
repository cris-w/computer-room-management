package com.manage.computerroommanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.computerroommanagement.entity.LabOrder;
import java.util.Date;

/**
* @author wjh
* @description 针对表【lab_order(实验室预约情况表)】的数据库操作Service
* @createDate 2022-02-25 15:36:28
*/
public interface LabOrderService extends IService<LabOrder> {

    /**
     * 通过实验室id修改实验室状态
     *
     * @param labId
     * @param date
     * @param time
     */
    void updateByLabId(Long labId, Date date, Integer time);
}
