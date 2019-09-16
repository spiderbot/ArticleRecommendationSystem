package com.learn.articlerecommendation.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RelationshipEntity(type="Bookmarked")
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

	private String id;
	
	@StartNode
	private Person person;
	
	@EndNode
	private Article article;
	
	private String a;


}