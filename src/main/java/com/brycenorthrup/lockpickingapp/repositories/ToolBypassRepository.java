package com.brycenorthrup.lockpickingapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.ToolBypass;

public interface ToolBypassRepository extends CrudRepository<ToolBypass, Integer> {
	@Query(value="SELECT count(*) FROM tool_bypass", nativeQuery=true)
	public int countBypass();
}
