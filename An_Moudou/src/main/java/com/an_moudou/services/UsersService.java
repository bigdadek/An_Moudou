package com.an_moudou.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.an_moudou.entities.Users;
import com.an_moudou.repositories.UsersRepository;

@Service
public class UsersService implements ServiceInterface<Users>  {
	
	@Autowired
	private UsersRepository userRep;
	
	@Override
	public List<Users> getAll() {
		return userRep.findAll();
	}

	@Override
	public Optional<Users> getById(long id) {
		return userRep.findById(id);
	}
	
	@Override
	public Users add(Users user) {
		return userRep.saveAndFlush(user);
	}

	@Override
	public Users update(Users user) {
		return userRep.saveAndFlush(user);
	}

	@Override
	public boolean delete(long id) {
		try {
			userRep.deleteById(id);
			return true;
		}
		catch (Exception e){ e.printStackTrace(); }
		return false;
	}
}

