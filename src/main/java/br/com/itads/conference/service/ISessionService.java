package br.com.itads.conference.service;

import java.util.List;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.User;

public interface ISessionService {

	String addSession(Session session);

	Session getSessionDetails(String sessionId);

	String subscribeSession(Session session, User user);

	List<Session> listSessions();
	
}
