package com.manage.computerroommanagement.entity.Bo;

import lombok.Data;

/**
 * @author wjh
 * @date 2022/3/2 4:18 PM
 */
@Data
public class OrderBo {

    /**
     * 实验室ID
     */
    private Long labId;

    /**
     * 预约人id
     */
    private Long userId;

    /**
     * 预约日期
     */
    private Long date;

    /**
     * 预约时间段：1、2、3、4
     */
    private Integer time;

    /**
     * 备注
     */
    private String remark;
}
