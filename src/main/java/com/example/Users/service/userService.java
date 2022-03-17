package com.example.Users.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Users.models.userModels;
import com.example.Users.repository.user_repository;

@Service
public class userService {

	@Autowired
	private user_repository repository;

	// GET
	public List<userModels> findAll() {
		return repository.findAll();
	}

	// GET POR ID
	public userModels findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	// PUT POR ID
	public userModels updateUsersById(Long id, userModels users) {
		userModels updateUsers = findById(id);
		if (updateUsers == null) {
			return null;
		} else {
			updateUsers.setUsername(users.getUsername());
			updateUsers.setUpdated_on(users.getUpdated_on());
			return repository.save(updateUsers);
		}

	}

	// POST
	public userModels save(userModels users) {
		return repository.save(users);
	}

	// DELETE
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	public userModels Listar(Long id_user) {
		return null;
	}

	// LISTA
	public userModels Listar(long id) {

		return repository.findById(id).orElse(null);
	}
}