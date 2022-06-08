package com.brycenorthrup.lockpickingapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.ToolPick;

public interface ToolPickRepository extends CrudRepository<ToolPick, Integer> {

}
