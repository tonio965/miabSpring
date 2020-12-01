package com.miab.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.miab.model.User;

@Service
public class UserServiceImpl implements UserService, HashService {

	@Override
	public String getHash(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}
