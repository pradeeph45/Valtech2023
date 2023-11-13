package com.valtech.training.firstspringboot.service;


import com.valtech.training.firstspringboot.entity.User;
import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;

public interface AuthService {

	User createUser(RegisterUserModel registerUserModel);

	boolean changePassword(ChangePasswordModel changePasswordModel);

	void upgradeUserToAdmin(long id);

	void enableUser(long id);

	void disableUser(long id);

}