package com.re5lect.layoffs.repository;

import com.re5lect.layoffs.model.NewsArticle;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewsArticleRepository extends CassandraRepository<NewsArticle, UUID> {
    // Custom query methods can be defined here if needed
}
