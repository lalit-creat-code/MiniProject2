package com.lalit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.binding.LoginForm;
import com.lalit.binding.RegisterForm;
import com.lalit.binding.ResetPasswordForm;
import com.lalit.entity.Cities;
import com.lalit.entity.Country;
import com.lalit.entity.States;
import com.lalit.entity.User;
import com.lalit.repo.CitiesRepo;
import com.lalit.repo.CountryRepo;
import com.lalit.repo.StatesRepo;
import com.lalit.repo.UserRepo;
import com.lalit.utils.EmailUtils;

@Service
public class ServiceImpl implements ServiceInterface {
	@Autowired 
	private CitiesRepo cityrepo;
	@Autowired
	private CountryRepo crepo;
	@Autowired
	private StatesRepo srepo;
	@Autowired
	private UserRepo urepo;
	@Autowired
	private EmailUtils util;
	
	public Map<Integer,String> getCountries(){
		List<Country>list=crepo.findAll();
		Map<Integer,String> countries=new HashMap();
		list.forEach(c -> {
			countries.put(c.getCountryId(), c.getCname());
		});
		return countries;
	}
	
	
		@Override
		public Map<Integer,String> getStates(int CountryId){
			List <States>list=srepo.findByCountryId( CountryId);
			Map<Integer,String> states=new HashMap();
			list.forEach(s-> {
				states.put(s.getStateId(), s.getStateName());
			});
			return states;
		}
		@Override
		public Map<Integer,String>getCities(int StateId){
			List<Cities>list=cityrepo.findByStateId(StateId);
			Map<Integer,String> cities=new HashMap();
			list.forEach(c-> {
				cities.put(c.getCityId(), c.getCityName());
			});
			  
			
			return cities;
		}
		@Override
		public User getUser(String Email) {
			return urepo.findByEmail(Email);
		}
		@Override
		public boolean saveUser(RegisterForm object) {
			object.setPassword(RandomPassword());
			object.setPwdUpdated("NO");
			User user=new User();
			 BeanUtils.copyProperties(object, user);
			 urepo.save(user);
			 String to= object.getEmail();
			 String subject="Password is";
			 String body=object.getPassword();
			 return util.sendMessage(to, subject, body);
			
			}
		@Override
		public User login(LoginForm object) {
			 User user= urepo.findByEandP(object.getEmail(),object.getPassword());
			 return user;
			
			}
		
		
		        public String RandomPassword() {
			           int length = 5;
			        String symbol = "-/.^&*_!@%=+>)"; 
			        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
			        String small_letter = "abcdefghijklmnopqrstuvwxyz"; 
			        String numbers = "0123456789"; 


			        String finalString = cap_letter + small_letter + 
			                numbers + symbol; 

			        Random random = new Random(); 

			        char[] password = new char[length]; 

			        for (int i = 0; i < length; i++) 
			        { 
			            password[i] = 
			                    finalString.charAt(random.nextInt(finalString.length())); 

			        } 
			      
			         return password.toString();
			       }
	@Override
	public boolean resetpassword(ResetPasswordForm object) {
					
					
			            Optional<User> optional=  urepo.findById(object.getUserId());
			            if(optional.isPresent()) {
			         	          User user = optional.get();
			         	            user.setPassword(object.getNewPassword());
			         	            user.setPwdUpdated("YES");
			         	            urepo.save(user);
			         	              return true;
			         	              }
			              return false;
				}


		}

	