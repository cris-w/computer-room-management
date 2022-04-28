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
 * 实验室预约情况表
 * @TableName lab_order
 */
@TableName(value ="lab_order")
@Data
public class LabOrder implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 实验室id
     */
    private Long labId;

    /**
     * 日期
     */
    private Date date;

    /**
     * 时间段1预约人数
     */
    private Integer timeA;

    /**
     * 时间段2预约人数
     */
    private Integer timeB;

    /**
     * 时间段3预约人数
     */
    private Integer timeC;

    /**
     * 时间段4预约人数
     */
    private Integer timeD;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}