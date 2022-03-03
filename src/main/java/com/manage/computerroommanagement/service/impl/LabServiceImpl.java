package com.manage.computerroommanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.Lab;
import com.manage.computerroommanagement.entity.LabOrder;
import com.manage.computerroommanagement.service.LabOrderService;
import com.manage.computerroommanagement.service.LabService;
import com.manage.computerroommanagement.mapper.LabMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【lab(实验室表)】的数据库操作Service实现
* @createDate 2022-02-25 15:36:28
*/
@Service
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab>
    implements LabService{

    @Resource
    private LabMapper labMapper;
    @Resource
    private LabOrderService labOrderService;

    @Override
    public boolean deleteById(Long id) {
        // 删除实验室表记录
        labMapper.deleteById(id);
        // 删除实验室预约表记录
        return labOrderService.remove(
                new LambdaQueryWrapper<LabOrder>().eq(LabOrder::getLabId, id));
    }
}




