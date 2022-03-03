package com.manage.computerroommanagement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manage.computerroommanagement.entity.LabOrder;
import com.manage.computerroommanagement.service.LabOrderService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputerRoomManagermentApplicationTests {

    @Autowired
    private LabOrderService labOrderService;

    @Test
    void contextLoads() {
//        Calendar calendar = Calendar.getInstance();
//        List<LabOrder> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            calendar.add(Calendar.DATE, 1);
//            LabOrder labOrder = new LabOrder();
//            labOrder.setLabId(1L);
//            labOrder.setDate(calendar.getTime());
//            labOrder.setTimeB(0);
//            labOrder.setTimeA(0);
//            labOrder.setTimeC(0);
//            labOrder.setTimeD(0);
//            list.add(labOrder);
//        }
//        labOrderService.saveBatch(list);
    }

    @Test
    void testTime() {
        Date date = new Date(1647273600000L);
        LabOrder labOrder = new LabOrder();
        labOrder.setDate(date);
        labOrder.setLabId(2L);
        labOrder.setTimeA(0);
        labOrder.setTimeB(0);
        labOrder.setTimeC(0);
        labOrder.setTimeD(0);
        labOrderService.save(labOrder);
    }

}
