package org.softuni.jobboard.web;

import org.softuni.jobboard.service.OfferService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Schedule {

    private final OfferService offerService;

    public Schedule(OfferService offerService) {
        this.offerService = offerService;
    }

    @Scheduled(cron = "0 30 23 * * *")
    public void proceedOffersTask (){
        offerService.proceedOfferTask();
    }
}
