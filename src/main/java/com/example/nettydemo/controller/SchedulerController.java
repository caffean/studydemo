package com.example.nettydemo.controller;

import com.example.nettydemo.service.SchedulerService;
import domain.form.SchedulerForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SchedulerController
 * @Description 动态定时任务
 * @Date 2019/8/16 15:58
 * @Author lyn
 */
@RestController
public class SchedulerController {

    private SchedulerService schedulerServiceImpl;

    public SchedulerController(SchedulerService schedulerServiceImpl) {
        this.schedulerServiceImpl = schedulerServiceImpl;
    }
    @PostMapping("/setcron")
    private void setCron(@RequestBody SchedulerForm form){
        schedulerServiceImpl.setCron(form);
    }
}
