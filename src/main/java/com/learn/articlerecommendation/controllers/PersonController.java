package com.learn.articlerecommendation.controllers;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.articlerecommendation.domain.Article;
import com.learn.articlerecommendation.domain.Person;
import com.learn.articlerecommendation.services.ArticleRepository;
import com.learn.articlerecommendation.services.PersonRepository;

@RestController
@RequestMapping("/user/")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ArticleRepository articleRepository;

	
	@PostMapping(value = "")
	public ResponseEntity<?> createPerson(@RequestBody CreatePersonRequest request) {
		Person person = new Person();
		person.setEmailId(request.getEmail());
		person.setUserName(request.getUserName());
		String id = "node1-" + System.currentTimeMillis();
		person.setId(id);
		personRepository.save(person);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@PostMapping("/readArticle/{personId}")
	public ResponseEntity<?> readArticle(@NotNull @PathVariable("personId") String personId,
			@RequestBody ReadArticleRequest request) {
		Optional<Person> found = personRepository.findById(personId);
		if (found.isPresent()) {
			Optional<Article> foundUser = articleRepository.findById(request.getArticleId());
			if (!foundUser.isPresent()) {
				throw new RuntimeException();
			}
			found.get().getBookmarked().add(foundUser.get());
		}
		personRepository.save(found.get());
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/addFriend/{personId}")
	public ResponseEntity<?> addFriend(@NotNull @PathVariable("personId") String personId,
			@RequestBody AddFriendRequest request) {
		Optional<Person> found = personRepository.findById(personId);
		if (found.isPresent()) {
			Optional<Person> foundUser = personRepository.findById(request.getUserId());
			if (!foundUser.isPresent()) {
				throw new RuntimeException();
			}
			found.get().getFollows().add(foundUser.get());
		}
		personRepository.save(found.get());
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity(personRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getArticlesPopularAmongFollwedPersons/{personId}")
	public ResponseEntity<?> getAllRecommendedArticlesByFriends(@NotNull @PathVariable String personId){
		return new ResponseEntity(articleRepository.getArticlesReadByFollowedUsers(personId),HttpStatus.OK);
	}
}
