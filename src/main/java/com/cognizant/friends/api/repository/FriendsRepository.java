package com.cognizant.friends.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.friends.api.entity.FriendsEntity;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsEntity, Integer> {
	
	//@Modifying
	@Query(value="select count(*) from friend_contact_tab where phone_number=? and friend_number=?",nativeQuery=true)
	Integer checkFriendContact(Long phoneNumber,Long friendNumber);
	
	@Query(value="select friend_number from friend_contact_tab where phone_number=?",nativeQuery=true)
	List<Long> findFriendsContactNumbers(Long phoneNumber);
		
}
