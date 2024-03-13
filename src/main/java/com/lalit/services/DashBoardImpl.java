package com.lalit.services;

import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lalit.binding.Quote;
import com.lalit.binding.QuoteApiResponse;

@Service
public class DashBoardImpl implements DashBoardSeviceInterFace {
	String url= "https://type.fit/api/quotes";
	Quote[]response=null;
	@Override
	public String getQoute() {
		;
		
		if(response==null) {
			
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> entity
		  = restTemplate.getForEntity(url , String.class);
		//Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		  String body=entity.getBody();
		          ObjectMapper mapper=new ObjectMapper();
		           try {
					response= mapper.readValue(body,Quote[].class );
					 
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           

	}
		     Random random=new Random();
		       int nextInt=random.nextInt(response.length);
		       return response[nextInt].getText();
		
	
}
}
