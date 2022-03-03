package com.manage.computerroommanagement.service;

import com.manage.computerroommanagement.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.computerroommanagement.entity.vo.OrderVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【order(实验室预约表)】的数据库操作Service
* @createDate 2022-02-25 15:36:28
*/
public interface OrderService extends IService<Order> {

    /**
     * 通过状态获取order List
     *
     * @param status
     * @return
     */
    List<OrderVo> getOrderList(Integer status);
}
