package com.manage.computerroommanagement.mapper;

import com.manage.computerroommanagement.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manage.computerroommanagement.entity.vo.OrderVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【order(实验室预约表)】的数据库操作Mapper
* @createDate 2022-02-25 15:36:28
* @Entity generator.domain.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 获取申请列表
     *
     * @return
     */
    List<OrderVo> getOrderList();

    /**
     * 通过状态获取申请列表
     *
     * @param status 状态
     * @return
     */
    List<OrderVo> getOrderListByStatus(Integer status);
}




