package com.learn.articlerecommendation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.articlerecommendation.domain.Article;
import com.learn.articlerecommendation.services.ArticleRepository;
import com.learn.articlerecommendation.services.PersonRepository;

@RestController
@RequestMapping("/article/")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	PersonRepository personRepository;

	@PostMapping(value = "")
	public ResponseEntity<?> createArticle(@RequestBody CreateArticleRequest request) {
		Article article = new Article();
		article.setUrl(request.getUrl());
		String id = "node1-" + System.currentTimeMillis();
		article.setId(id);
		articleRepository.save(article);
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllArticles(){
		return new ResponseEntity(articleRepository.findAll(),HttpStatus.OK);
	}

}
