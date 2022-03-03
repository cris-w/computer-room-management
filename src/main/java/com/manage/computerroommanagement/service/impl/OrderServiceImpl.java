package com.manage.computerroommanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.Order;
import com.manage.computerroommanagement.entity.vo.OrderVo;
import com.manage.computerroommanagement.service.OrderService;
import com.manage.computerroommanagement.mapper.OrderMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【order(实验室预约表)】的数据库操作Service实现
* @createDate 2022-02-25 15:36:28
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderVo> getOrderList(Integer status) {
        List<OrderVo> list = null;
        if(status == -1) {
            list = orderMapper.getOrderList();
        } else {
            list = orderMapper.getOrderListByStatus(status);
        }

        return list;
    }
}




