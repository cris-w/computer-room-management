package com.manage.computerroommanagement.controller;

import com.manage.computerroommanagement.entity.Bo.OrderBo;
import com.manage.computerroommanagement.entity.Order;
import com.manage.computerroommanagement.entity.vo.OrderVo;
import com.manage.computerroommanagement.service.LabOrderService;
import com.manage.computerroommanagement.service.OrderService;
import com.manage.computerroommanagement.utils.R;
import io.swagger.annotations.Api;
import java.util.Date;
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
 * @date 2022/3/2 4:02 PM
 */
@Api(tags = "预约管理")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private LabOrderService labOrderService;

    /**
     * 创建预约
     *
     * @param orderBo order
     * @return ok
     */
    @PostMapping("/createOrder")
    public R<Void> createOrder(@RequestBody OrderBo orderBo) {

        Order order = new Order();
        order.setUserId(orderBo.getUserId());
        order.setLabId(orderBo.getLabId());
        Date date = new Date(orderBo.getDate());
        order.setDate(date);
        order.setTime(orderBo.getTime());
        order.setRemark(orderBo.getRemark());
        order.setStatus(0);
        orderService.save(order);

        return R.success("创建成功");
    }

    /**
     * 通过状态获取预约列表
     *
     * @param status 状态
     * @return list
     */
    @GetMapping("/getByStatus/{status}")
    public R<List<OrderVo>> list(@PathVariable Integer status) {
        List<OrderVo> list = orderService.getOrderList(status);;
        return R.success(list);
    }

    /**
     * 删除
     *
     * @param ids ids
     * @return ok
     */
    @PostMapping("delete")
    public R<Void> delete(@RequestBody List<Integer> ids) {
        orderService.removeByIds(ids);
        return R.success("删除成功");
    }

    /**
     * 更新
     *
     * @param order order
     * @return ok
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Order order) {
        if(order.getStatus() == 1) {
            Order o = orderService.getById(order.getId());
            Date date = o.getDate();
            Integer time = o.getTime();
            Long labId = o.getLabId();
            labOrderService.updateByLabId(labId, date, time);
        }
        orderService.updateById(order);
        return R.success("更新成功");
    }

}
