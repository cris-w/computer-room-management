package com.manage.computerroommanagement.entity.vo;

import java.util.Date;
import lombok.Data;

/**
 * @author wjh
 * @date 2022/3/2 6:31 PM
 */
@Data
public class OrderVo {
    private Long id;
    private String name;
    private String username;
    private Date date;
    private Integer time;
    private String remark;
    private Integer status;
}
