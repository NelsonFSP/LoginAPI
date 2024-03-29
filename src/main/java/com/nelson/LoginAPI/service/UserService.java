package com.nelson.LoginAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelson.LoginAPI.domain.User;
import com.nelson.LoginAPI.repository.UserRepository;
import com.nelson.LoginAPI.service.exception.ObjectNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		repo.deleteById(id);
	}
	
	public void update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setLogin(obj.getLogin());
		newObj.setPassword(obj.getPassword());
	}
}
