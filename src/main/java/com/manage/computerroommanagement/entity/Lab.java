package com.manage.computerroommanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 实验室表
 * @author wjh
 * @TableName lab
 */
@TableName(value ="lab")
@Data
public class Lab implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 实验室名
     */
    private String name;

    /**
     * 实验室描述
     */
    private String description;

    /**
     * 实验室人数
     */
    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}