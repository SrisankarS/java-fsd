package com.project.usermanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.usermanager.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
}
