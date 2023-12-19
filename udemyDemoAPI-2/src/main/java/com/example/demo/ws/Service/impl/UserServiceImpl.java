package com.example.demo.ws.Service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepo;
import com.example.demo.ws.Service.UserService;
import com.example.demo.ws.io.Entity.UserEntity;
import com.example.demo.ws.shared.MyUtils;
import com.example.demo.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	MyUtils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {
		UserEntity storeUser = userRepo.findUserByEmail(user.getEmail());
		if(storeUser != null) {
			throw new RuntimeException("Duplicate Recorde");
		}

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String publicUserId = utils.generateUserId(16);
		userEntity.setUserId(publicUserId);


		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		//save in DB
		UserEntity userEntityDB = userRepo.save(userEntity);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntityDB, userDto);

		return userDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
