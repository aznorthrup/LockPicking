package com.brycenorthrup.lockpickingapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brycenorthrup.lockpickingapp.entities.LockClass;

public interface LockClassRepository extends CrudRepository<LockClass, Integer>{
	@Query(value="SELECT count(*) FROM lock_class", nativeQuery=true)
	public int countLocks();
}
