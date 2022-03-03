package com.manage.computerroommanagement.t;

import cn.hutool.core.date.DateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wjh
 * @date 2022/3/1 10:11 PM
 */
public class Test {


    @org.junit.jupiter.api.Test
    public void TestDate() {
        Calendar calendar = Calendar.getInstance();
        List<Date> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DATE, 1);
            list.add(calendar.getTime());
        }
        System.out.println(list);
    }
}
