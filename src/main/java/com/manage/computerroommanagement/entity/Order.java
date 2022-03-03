package com.manage.computerroommanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author wjh
 * 实验室预约表
 * @TableName order
 */
@TableName(value ="`order`")
@Data
public class Order implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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
    private Date date;

    /**
     * 预约时间段：1、2、3、4
     */
    @TableField("`time`")
    private Integer time;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预约状态：0 未处理 1 同意 2 拒绝
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}