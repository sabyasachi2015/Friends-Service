package com.cognizant.friends.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.friends.api.entity.FriendsEntity;
import com.cognizant.friends.api.service.IFriendsService;

@RestController
@RequestMapping("/api/v1/friend")
public class FriendsRestController {

	@Autowired
	private IFriendsService friendsService;


	@PostMapping("/addNumber")
	public ResponseEntity<? extends Object> addFriendsContact(@RequestBody FriendsEntity friendsEntity) {
		//call service layer
		
		String addFriendService = friendsService.addFriendService(friendsEntity);
		
		return new ResponseEntity<Object>(addFriendService, HttpStatus.CREATED);

		/*
		 * // call service layer method Integer addedFriendService =
		 * friendsService.addFriendService(friendsEntity); if (addedFriendService != 0)
		 * { // display success message String successMsg =
		 * appProprties.getProperties().get(AppConstants.FRIEND_CONTACT_ADDED); return
		 * new ResponseEntity<Object>(successMsg, HttpStatus.CREATED); } else { //
		 * Display failure message String failureMsg =
		 * appProprties.getProperties().get(AppConstants.FRIEND_CONTACT_EXIST); return
		 * new ResponseEntity<Object>(failureMsg, HttpStatus.BAD_REQUEST); }
		 */
	}

	@GetMapping("/{phoneNumber}")
	public ResponseEntity<?> fetchFriendContacts(@PathVariable Long phoneNumber) {

		// call service layer method
		List<Long> listContacts = friendsService.getAllFriendsContact(phoneNumber);

		/*if (null != listContacts && !listContacts.isEmpty()) {

			return new ResponseEntity<List<Long>>(listContacts, HttpStatus.OK);
		} else {*/
			return new ResponseEntity<>(listContacts, HttpStatus.OK);
		}
	}

