package com.lalit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lalit.binding.LoginForm;
import com.lalit.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	@Query("from User where Email=?1")
	public User findByEmail(String Email);
	@Query("   from User where Email=:email and Password=:password")
	public User findByEandP(@Param("email")String email,@Param("password")String password);

}
