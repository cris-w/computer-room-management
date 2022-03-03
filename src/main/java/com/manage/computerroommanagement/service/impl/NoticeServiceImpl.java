package com.manage.computerroommanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.computerroommanagement.entity.Notice;
import com.manage.computerroommanagement.service.NoticeService;
import com.manage.computerroommanagement.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【notice(公告表)】的数据库操作Service实现
* @createDate 2022-02-25 15:36:28
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




