package com.lalit.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.entity.Country;

public interface CountryRepo extends JpaRepository<Country,Integer> {

}
