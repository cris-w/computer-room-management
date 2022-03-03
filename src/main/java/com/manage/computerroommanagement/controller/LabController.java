package com.manage.computerroommanagement.controller;

import com.manage.computerroommanagement.entity.Lab;
import com.manage.computerroommanagement.service.LabService;
import com.manage.computerroommanagement.utils.R;
import io.swagger.annotations.Api;
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
 * @date 2022/2/25 3:43 PM
 */
@Api(tags = "实验室管理")
@RestController
@RequestMapping("/lab")
public class LabController {

    @Resource
    private LabService labService;

    /**
     * 获取所有实验室信息
     *
     * @return list
     */
    @GetMapping("/list")
    public R<List<Lab>> list() {
        List<Lab> list = labService.list();
        return R.success(list);
    }

    /**
     * 通过ID获取实验室信息
     *
     * @param id id
     * @return lab
     */
    @GetMapping("/getById/{id}")
    public R<Lab> getById(@PathVariable Long id) {
        Lab lab = labService.getById(id);
        return R.success(lab);
    }


    /**
     * 添加实验室
     *
     * @param lab lab
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Lab lab) {
        labService.save(lab);
        return R.success("添加成功");
    }

    /**
     * 通过id修改实验室信息
     *
     * @param lab lab
     * @return ok
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Lab lab) {
        labService.updateById(lab);
        return R.success("修改成功");
    }

    /**
     * 通过id删除实验室信息
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/delete/{id}")
    public R<Void> delete(@PathVariable Long id) {
        labService.deleteById(id);
        return R.success("删除成功");
    }
}
