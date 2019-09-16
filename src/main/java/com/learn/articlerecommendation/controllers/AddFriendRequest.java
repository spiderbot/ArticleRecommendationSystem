package com.learn.articlerecommendation.controllers;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddFriendRequest {
	
	@NotNull
	private String userId;

}
