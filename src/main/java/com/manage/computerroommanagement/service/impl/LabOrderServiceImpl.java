package com.manage.computerroommanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.LabOrder;
import com.manage.computerroommanagement.exception.MyException;
import com.manage.computerroommanagement.service.LabOrderService;
import com.manage.computerroommanagement.mapper.LabOrderMapper;
import com.manage.computerroommanagement.service.LabService;
import com.manage.computerroommanagement.service.OrderService;
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
    @Resource
    private LabService labService;

    @Override
    public void updateByLabId(Long labId, Date date, Integer time, Integer num) {
        // 实验室总人数
        int sum = labService.getById(labId).getNum();
        LabOrder labOrder = labOrderMapper.selectByLabId(labId, date);
        if (time == 1) {
            // 时间段a 已经预约的人数
            Integer timeA = labOrder.getTimeA();
            // 如果超过总人数
            if (timeA + num > sum) {
                throw new MyException(500, "该实验室空位不足，请拒绝此申请");
            }
            labOrder.setTimeA(labOrder.getTimeA() + num);
        } else if (time == 2) {
            Integer timeB = labOrder.getTimeB();
            if (timeB + num > sum) {
                throw new MyException(500, "该实验室空位不足，请拒绝此申请");
            }
            labOrder.setTimeB(labOrder.getTimeB() + num);
        } else if (time == 3) {
            Integer timeC = labOrder.getTimeC();
            if (timeC + num > sum) {
                throw new MyException(500, "该实验室空位不足，请拒绝此申请");
            }
            labOrder.setTimeC(labOrder.getTimeC() + num);
        } else {
            Integer timeD = labOrder.getTimeD();
            if (timeD + num > sum) {
                throw new MyException(500, "该实验室空位不足，请拒绝此申请");
            }
            labOrder.setTimeD(labOrder.getTimeD() + num);
        }
        labOrderMapper.updateById(labOrder);
    }

    @Override
    public List<LabOrder> listByIdOrDate(Long id, String date) {
        return labOrderMapper.selectListByIdOrDate(id, date);
    }
}




