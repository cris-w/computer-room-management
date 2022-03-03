package com.manage.computerroommanagement.controller;

import com.manage.computerroommanagement.entity.Notice;
import com.manage.computerroommanagement.service.NoticeService;
import com.manage.computerroommanagement.utils.R;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/3/2 8:09 PM
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @PostMapping("/save")
    public R<Void> save(@RequestBody Notice notice) {
        notice.setCreated(new Date());
        noticeService.save(notice);
        return R.success("创建成功");
    }

    @GetMapping("/delete/{id}")
    public R<Void> delete(@PathVariable Long id) {
        noticeService.removeById(id);
        return R.success("删除成功");
    }

    @GetMapping("/list")
    public R<List<Notice>> list() {
        List<Notice> list = noticeService.list();
        return R.success(list);
    }

    @GetMapping("/getById/{id}")
    public R<Notice> getById(@PathVariable Long id) {
        Notice notice = noticeService.getById(id);
        return R.success(notice);
    }
}
