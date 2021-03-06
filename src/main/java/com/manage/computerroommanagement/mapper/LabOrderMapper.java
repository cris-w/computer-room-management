package com.manage.computerroommanagement.mapper;

import com.manage.computerroommanagement.entity.LabOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author wjh
* @description 针对表【lab_order(实验室预约情况表)】的数据库操作Mapper
* @createDate 2022-02-25 15:36:28
* @Entity generator.domain.LabOrder
*/
public interface LabOrderMapper extends BaseMapper<LabOrder> {

    /**
     * 通过labID获取labOrder
     *
     * @param labId id
     * @param date date
     * @return
     */
    LabOrder selectByLabId(@Param("labId") Long labId,@Param("date") Date date);

    /**
     * 通过id 或者日期 获取排期表
     *
     * @param id
     * @param date
     * @return
     */
    List<LabOrder> selectListByIdOrDate(@Param("id") Long id,@Param("date") String date);
}




