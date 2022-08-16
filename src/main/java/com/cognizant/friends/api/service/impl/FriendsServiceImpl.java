package com.cognizant.friends.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.friends.api.constants.AppConstants;
import com.cognizant.friends.api.entity.FriendsEntity;
import com.cognizant.friends.api.repository.FriendsRepository;
import com.cognizant.friends.api.service.IFriendsService;

@Service
public class FriendsServiceImpl implements IFriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;

	@Override
	public String addFriendService(FriendsEntity friendsEntity) {
	//call repository layer
					
		Integer friendsContactCount1 = friendsRepository.checkFriendContact(friendsEntity.getPhoneNumber(),
				                                                            friendsEntity.getFriendNumber());
		if (friendsContactCount1 == 0) {
			friendsRepository.saveAndFlush(friendsEntity);
			return "Friend contact is added";
		} else {
			return "Friend contact already exist";
		}
	}


	@Override
	public List<Long> getAllFriendsContact(Long phoneNumber) {
		
		//call repository layer
		return friendsRepository.findFriendsContactNumbers(phoneNumber);
		
		//return friendsContactList;
	}
}

















