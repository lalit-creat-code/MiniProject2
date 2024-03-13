package com.lalit.dataLoader;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.lalit.entity.Cities;
import com.lalit.entity.Country;
import com.lalit.entity.States;
import com.lalit.repo.CitiesRepo;
import com.lalit.repo.CountryRepo;
import com.lalit.repo.StatesRepo;
@Component
public class DataLoaderClass implements ApplicationRunner{
	@Autowired
	StatesRepo srepo;
	@Autowired
	CitiesRepo cityRepo;
	@Autowired
	CountryRepo crepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		srepo.deleteAll();
		cityRepo.deleteAll();
		crepo.deleteAll();
		
		
		Country c1=new Country(1,"India");
		Country c2=new Country(2,"U.S.A");
		  crepo.saveAll(Arrays.asList(c1,c2));
		   
		  States s1=new States(1,"UP",1);
		  States s2=new States(2,"Bihar",1);
		  States s3=new States(3,"Texas",2);
		  States s4=new States(4,"califronia",2);
		    srepo.saveAll(Arrays.asList(s1,s2,s3,s4));
		    
		    Cities city1=new Cities("varansi",1,1);
		    Cities city2=new Cities("Ayodhya",2,1);
		    Cities city3=new Cities("Gaya",3,2);
		    Cities city4=new Cities("Patna",4,2);
		    Cities city5=new Cities("Texas1",5,3);
		    Cities city6=new Cities("Texas2",6,3);
		    Cities city7=new Cities("California1",7,4);
		    Cities city8=new Cities("California2",8,4);
		    
		    cityRepo.saveAll(Arrays.asList(city1,city2,city3,city4,city5,city6,city7,city8));		    
		     
		
	}
	

}
