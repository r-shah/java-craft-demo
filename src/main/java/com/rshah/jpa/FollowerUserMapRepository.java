package com.rshah.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rshah.entity.FollowerUserMap;

public interface FollowerUserMapRepository extends JpaRepository<FollowerUserMap, Long> {

	/*
	 * For specific user_id (that is following_user_id), get all user_ids they
	 * are being followed (which are followed_user_id) by that specific user
	 */
	@Query(nativeQuery = true)
	List<FollowerUserMap> getFollowedIdsByFollowingUserId(@Param("followingUserId") Long followingUserId);

}
