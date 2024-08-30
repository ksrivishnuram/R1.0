package com.re5lect.layoffs.controller;
import com.re5lect.layoffs.service.KafkaProducerService;
import com.re5lect.layoffs.service.NyTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NyTimesController {
    @Autowired
    private NyTimesService nyTimesService;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @GetMapping("/fetch-and-stream")
    public String fetchAndStreamNews(){
        String newsData= nyTimesService.fetchNewsData();
        if(newsData!= null){
            kafkaProducerService.sendMessage(newsData);
            return "News data fetched and sent to Kafka";
        }else{
            return "failed to fetch news data";
        }
    }

}
