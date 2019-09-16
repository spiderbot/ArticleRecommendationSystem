package com.learn.articlerecommendation.services;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.learn.articlerecommendation.domain.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, String>{


}
