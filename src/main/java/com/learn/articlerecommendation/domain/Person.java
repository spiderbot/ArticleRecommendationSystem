package com.learn.articlerecommendation.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NodeEntity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	String id;
	String userName;
	String emailId;

	@Relationship(type = "Bookmarked")
	private List<Article> bookmarked = new ArrayList<>();

	@Relationship(type = "Follows", direction = Relationship.UNDIRECTED)
	private Set<Person> follows = new HashSet<>();

//	public FriendShip addFriend(Person newFriend) {
//		FriendShip friendship = new FriendShip(this, newFriend);
//		this.friendShips.add(friendship);
//		return friendship;
//	}

}
