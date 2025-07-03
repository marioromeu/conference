package br.com.itads.conference.service.impl;

import org.springframework.stereotype.Service;

import br.com.itads.conference.domain.User;
import br.com.itads.conference.exception.ObjectNotFoundException;
import br.com.itads.conference.repository.UserRepository;
import br.com.itads.conference.service.IUserService;

@Service
public class UserService implements IUserService {

	UserRepository userRepository;
	
	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Boolean addUser(User user) {
		return userRepository.save(user) != null;
	}

	@Override
	public User getUser(String email) {
		return userRepository.findById(email)
				.orElseThrow(() -> new ObjectNotFoundException("User not found with email: " + email));
	}
}
