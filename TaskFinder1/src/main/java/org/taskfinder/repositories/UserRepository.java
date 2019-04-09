package org.taskfinder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskfinder.entities.User;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name); 
	User findOne(String email);
	//User findOne1(int id);
	User findByEmail(String email);

}
