package com.manage.computerroommanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manage.computerroommanagement.entity.LabOrder;
import com.manage.computerroommanagement.service.LabOrderService;
import com.manage.computerroommanagement.utils.R;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/3/1 9:47 PM
 */
@RestController
@RequestMapping("/labOrder")
public class LabOrderController {

    @Resource
    private LabOrderService labOrderService;

    /**
     * 通过获取预约列表
     *
     * @param id 实验室id
     * @param date  日期
     *
     * @return list
     */
    @GetMapping("/list")
    public R<List<LabOrder>> list(Long id, String date) {
        List<LabOrder> list = labOrderService.listByIdOrDate(id, date);
        return R.success(list);
    }

    /**
     * 通过时间戳获取预约情况
     *
     * @param time time
     * @return one
     */
    @GetMapping("/getTime/{time}")
    public R<LabOrder> getTime(@PathVariable Long time) {

        LabOrder one = labOrderService.getOne(
                new LambdaQueryWrapper<LabOrder>().eq(LabOrder::getDate, new Date(time)));

        return R.success(one);
    }




}
