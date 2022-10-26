package net.javaguides.sms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService{

private UserRepository userRepository;

public UserServiceImpl(UserRepository userRepository) {
super();
this.userRepository = userRepository;
}

@Override
public List<User> getAllUsers() {
return userRepository.findAll();
}

@Override
public User saveUser(User user) {
return userRepository.save(user);
}

@Override
public User getUserById(Long id) {
return userRepository.findById(id).get();
}

@Override
public User updateUser(User user) {
return userRepository.save(user);
}

@Override
public void deleteUserById(Long id) {
userRepository.deleteById(id);
}

@Override
public List<User>  userByOrderId() {
	List<User> users=getAllUsers();
	List<User> validuser=new ArrayList<>();
	
	for (User use:users) {
		if(use.getOrderId()==null) {
			validuser.add(use);
		}
	}
	return validuser;
}

}