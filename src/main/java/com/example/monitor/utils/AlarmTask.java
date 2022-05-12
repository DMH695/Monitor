package com.example.monitor.utils;

import com.example.recoverbysporting.service.PatientService;
import com.example.recoverbysporting.service.PrescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@EnableScheduling
public class AlarmTask {
    @Autowired
    PatientService patientService;
    @Autowired
    PrescribeService prescribeService;

    /**
     * 每天凌晨零点一分执行
     * 执行内容：
     *     遍历数据库，将两个date数据修改成null，条件是endDate<=nowDate
     */
    @Scheduled(cron = "0 1 0 * * ?")
    public void run1() throws InterruptedException {
        Date nowDate = new Date(System.currentTimeMillis());
        patientService.cancelVip(nowDate);
        prescribeService.reset();
        System.out.println("已完成会员检查机制和任务清空机制");
    }

}