package com.manage.computerroommanagement.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.manage.computerroommanagement.entity.Order;
import com.manage.computerroommanagement.service.OrderService;
import com.manage.computerroommanagement.utils.MyDateUtil;
import com.manage.computerroommanagement.utils.R;
import io.swagger.annotations.Api;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/4/22 14:40
 */
@Api("图表统计")
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Resource
    private OrderService orderService;
    @Resource
    private MyDateUtil myDateUtil;

    /**
     * 统计近7天的预约情况
     *
     * @return
     */
    @GetMapping("/getOrderNum")
    public R<Map<Object, Object>> getOrderNum() {
        String today = DateUtil.today();
        String last = DateUtil.format(DateUtil.offsetDay(new Date(), -6), "yyyy-MM-dd");
        List<Order> list = orderService.getOrderList(today, last);
        Map<Object, Object> weekList = myDateUtil.getWeekList(today);
        list.forEach(l -> {
            String time = DateUtil.format(l.getDate(), "yyyy-MM-dd");
            weekList.put(time, Integer.parseInt(String.valueOf(weekList.get(time))) + 1);
        });
        return R.success(MapUtil.builder()
                .put("week", weekList.keySet())
                .put("data", weekList.values())
                .build());
    }

    /**
     * 获取学年各学科预约时间情况
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/getSubYearOrder")
    public R<Map<Object, Object>> getSubYearOrder(String start, String end) {
        List<Order> list = orderService.getOrderList(end, start);
        Map<String, Integer> map = new HashMap<>(4);
        map.put("高数", 0);
        map.put("英语", 0);
        map.put("物理", 0);
        map.put("C语言", 0);
        list.forEach(val -> {
            if(val.getStatus() == 1) {
                map.put(val.getSubject(), map.get(val.getSubject()) + 2);
            }
        });
        return R.success(MapUtil.builder()
                .put("x", map.keySet())
                .put("y", map.values())
                .build());
    }
}
