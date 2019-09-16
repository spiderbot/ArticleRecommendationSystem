package com.learn.articlerecommendation.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RelationshipEntity(type="Follows")
public class Follows{

	public Follows(Person person, Person newFriend) {
		this.person1 = person;
		this.person2 = newFriend;
	}

	private String id;
	
	@StartNode
	private Person person1;
	
	@EndNode
	private Person person2;
	
	private String a;


}