package com.re5lect.layoffs.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.re5lect.layoffs.model.NewsArticle;
import com.re5lect.layoffs.repository.NewsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumerService {
    @Autowired
    private NewsArticleRepository newsArticleRepository;
    @KafkaListener(topics = "news-topic", groupId = "nytimes-group")
    public void consume(String message){
        System.out.println("Consumed message: "+ message);
        NewsArticle article = parseMessageToNewsArticle(message);
        newsArticleRepository.save(article);
    }
    private NewsArticle parseMessageToNewsArticle(String message){
        UUID id= UUID.randomUUID();
        String headline= extractHeadlineFromMessage(message);
        String content= extractContentFromMessage(message);
        return new NewsArticle(id, headline, content);
    }
    private String extractHeadlineFromMessage(String message){
//       implement extraction logic
        return "Sample Headline";
    }
    private String extractContentFromMessage(String message){
        //    implement extraction logic
        return "Sample Content";
    }
}
