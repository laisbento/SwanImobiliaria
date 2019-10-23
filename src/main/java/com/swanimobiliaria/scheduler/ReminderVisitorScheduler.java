package com.swanimobiliaria.scheduler;

import com.swanimobiliaria.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ReminderVisitorScheduler {

    private VisitService visitService;

    @Autowired
    public ReminderVisitorScheduler(VisitService visitService) {
        this.visitService = visitService;
    }

    @Scheduled(cron = "0 * * ? * *")
    private void sendDailyReminder(){
        visitService.sendVisitReminder();
    }
}