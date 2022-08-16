package com.cognizant.friends.api.service;

import java.util.List;

import com.cognizant.friends.api.entity.FriendsEntity;

public interface IFriendsService {
	
	//public boolean addFriendService(Friends friendsDto);
	
	String addFriendService(FriendsEntity friendsEntity);

	public List<Long> getAllFriendsContact(Long phoneNumber);

	
}
