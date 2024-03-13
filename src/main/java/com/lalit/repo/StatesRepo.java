package com.lalit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lalit.entity.States;

public interface StatesRepo extends JpaRepository<States,Integer> {
	@Query("from States where CountryId=?1")
	public List findByCountryId(int CountryId);

}
