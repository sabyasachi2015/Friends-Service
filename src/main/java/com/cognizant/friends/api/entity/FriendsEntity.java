package com.cognizant.friends.api.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FRIEND_CONTACT_TAB", schema="friend_details_schema")
@Data
public class FriendsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//private UUID id= UUID.randomUUID();
	
	private Long phoneNumber;
	
	private Long friendNumber;

}
