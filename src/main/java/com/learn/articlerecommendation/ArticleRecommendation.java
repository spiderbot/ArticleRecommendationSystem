package com.learn.articlerecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories("com.learn.articlerecommendation.services")
public class ArticleRecommendation {

	public static void main(String[] args) {
        SpringApplication.run(ArticleRecommendation.class, args);
    }
}