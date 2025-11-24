package com.nfspdev.loginAPI.core.service;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.core.exceptions.ObjectNotFoundException;
import com.nfspdev.loginAPI.core.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public abstract class DatabaseServiceImpl implements IUserRepository {
	@Override
	public List<User> findAll(){
		return findAll();
	}

	@Override
	public Optional<User> findById(String id) {
		Optional<User> obj = findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}

	@Override
	public User save(User obj) {
		return insert(obj);
	}

	@Override
	public void delete(String id) {
		deleteById(id);
	}

	@Override
	public void update(User obj) {
		Optional<User> newObj = findById(obj.getId());
		try{
			updateData(newObj.get(), obj);
			save(newObj.get());
		} catch (Exception e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setLogin(obj.getLogin());
		newObj.setPassword(obj.getPassword());
	}
}
