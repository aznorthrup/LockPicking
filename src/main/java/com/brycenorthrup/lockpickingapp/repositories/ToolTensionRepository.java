package com.brycenorthrup.lockpickingapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.ToolTension;

public interface ToolTensionRepository extends CrudRepository<ToolTension, Integer> {
	
	public List<ToolTension> findAll();

}
