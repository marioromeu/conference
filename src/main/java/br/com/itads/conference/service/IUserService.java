package br.com.itads.conference.service;

import br.com.itads.conference.domain.User;

public interface IUserService {

	Boolean addUser(User user);

	User getUser(String email);

}
