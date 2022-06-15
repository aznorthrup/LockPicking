package com.brycenorthrup.lockpickingapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.ToolPick;

public interface ToolPickRepository extends CrudRepository<ToolPick, Integer> {
	@Query(value="SELECT count(*) FROM tool_pick", nativeQuery=true)
	public int countPicks();
}
