package com.traineeapp.model.service;

import com.traineeapp.model.persistance.user.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username, String password);
}