package com.manage.computerroommanagement.entity.Bo;

import java.util.List;
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
     * 预约学科
     */
    private String subject;

    /**
     * 预约时间
     */
    private List<OrderTime> orderTimeList;

    /**
     * 备注
     */
    private String remark;
}
