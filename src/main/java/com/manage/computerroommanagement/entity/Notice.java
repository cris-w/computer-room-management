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
 * 公告表
 * @TableName notice
 */
@TableName(value ="notice")
@Data
public class Notice implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 发布者id
     */
    private Long userId;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告类容
     */
    private String content;

    /**
     * 发布时间
     */
    private Date created;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}