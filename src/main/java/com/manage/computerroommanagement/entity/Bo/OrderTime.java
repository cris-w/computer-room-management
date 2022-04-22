package com.manage.computerroommanagement.entity.Bo;

import lombok.Data;

/**
 * @author wjh
 * @date 2022/4/17 16:43
 *
 * 预约时间
 */
@Data
public class OrderTime {

    /**
     * 预约日期
     */
    private Long date;

    /**
     * 预约时间段：1、2、3、4
     */
    private Integer time;
}
