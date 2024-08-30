package com.re5lect.layoffs.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Table("news_article")
@AllArgsConstructor
public class NewsArticle {
    @Id
    private UUID id;
    private String headline;
    private String content;
}
