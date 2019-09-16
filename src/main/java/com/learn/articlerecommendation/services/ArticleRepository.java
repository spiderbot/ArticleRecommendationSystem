package com.learn.articlerecommendation.services;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.articlerecommendation.domain.Article;

@Repository
public interface ArticleRepository extends Neo4jRepository<Article, String>{

	
	@Query("match (p:Person{id:{userId}})-[:Follows]->(persons)-[:Bookmarked]->(articles) return articles")
//	WHERE m.title =~ ('(?i).*'+{title}+'.*')
//	@Query("match (p:Person) where p.id = ({userId})-[:Follows]->(persons)-[:Bookmarked]->(articles) return articles")
    List<Article> getArticlesReadByFollowedUsers(@Param("userId") String userId);

}
