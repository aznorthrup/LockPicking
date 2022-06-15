package com.brycenorthrup.lockpickingapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.ToolTension;

public interface ToolTensionRepository extends CrudRepository<ToolTension, Integer> {
	@Query(value="SELECT count(*) FROM tool_tension", nativeQuery=true)
	public int countTension();
	public List<ToolTension> findAll();

}
