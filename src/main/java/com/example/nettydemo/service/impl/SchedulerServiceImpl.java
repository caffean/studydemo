package com.example.nettydemo.service.impl;

import com.example.nettydemo.service.SchedulerService;
import domain.ReconciliationTask;
import domain.form.SchedulerForm;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

/**
 * @Classname SchedulerServiceImpl
 * @Description TODO
 * @Date 2019/8/16 16:04
 * @Author lyn
 */
@Service
public class SchedulerServiceImpl implements SchedulerService{

    private ScheduledFuture future;

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public SchedulerServiceImpl(ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;

    }


    @Override
    public void setCron(SchedulerForm form) {
        if (null != future) {
            //取消此任务
            future.cancel(true);
        }
        //0 00 20 * * ? 每天晚上8点钟开始执行
        future = threadPoolTaskScheduler.schedule(new ReconciliationTask(), new CronTrigger(form.getCron()));
    }


}
