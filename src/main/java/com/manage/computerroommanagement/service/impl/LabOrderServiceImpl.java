package com.manage.computerroommanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.LabOrder;
import com.manage.computerroommanagement.exception.MyException;
import com.manage.computerroommanagement.service.LabOrderService;
import com.manage.computerroommanagement.mapper.LabOrderMapper;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author wjh
 * @description 针对表【lab_order(实验室预约情况表)】的数据库操作Service实现
 * @createDate 2022-02-25 15:36:28
 */
@Service
public class LabOrderServiceImpl extends ServiceImpl<LabOrderMapper, LabOrder>
        implements LabOrderService {

    @Resource
    private LabOrderMapper labOrderMapper;

    @Override
    public void updateByLabId(Long labId, Date date, Integer time) {
        LabOrder labOrder = labOrderMapper.selectByLabId(labId, date);
        if (time == 1) {
            Integer timeA = labOrder.getTimeA();
            if(timeA == 1) {
                throw new MyException(500, "该实验室已被预约，请拒绝此申请");
            }
            labOrder.setTimeA(1);
        } else if (time == 2) {
            Integer timeB = labOrder.getTimeB();
            if(timeB == 1) {
                throw new MyException(500, "该实验室已被预约，请拒绝此申请");
            }
            labOrder.setTimeB(1);
        } else if (time == 3) {
            Integer timeC = labOrder.getTimeC();
            if(timeC == 1) {
                throw new MyException(500, "该实验室已被预约，请拒绝此申请");
            }
            labOrder.setTimeC(1);
        } else {
            Integer timeD = labOrder.getTimeD();
            if(timeD == 1) {
                throw new MyException(500, "该实验室已被预约，请拒绝此申请");
            }
            labOrder.setTimeD(1);
        }
        labOrderMapper.updateById(labOrder);
    }

    @Override
    public List<LabOrder> listByIdOrDate(Long id, String date) {
        return labOrderMapper.selectListByIdOrDate(id, date);
    }
}




