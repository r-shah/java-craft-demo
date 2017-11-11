package com.rshah.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rshah.entity.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {
	
	@Query(nativeQuery=true)
	List<Feed> getByUserIds(@Param("ids") List<Long> ids);
}
