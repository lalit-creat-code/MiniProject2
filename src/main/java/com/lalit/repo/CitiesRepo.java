package com.lalit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lalit.entity.Cities;

public interface CitiesRepo extends JpaRepository<Cities,Integer> {
	
	@Query(" From Cities where StateId=?1")
	public List findByStateId(int StateId);
	

}
