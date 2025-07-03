package br.com.itads.conference.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.Subscription;
import br.com.itads.conference.domain.SubscriptionID;
import br.com.itads.conference.domain.User;
import br.com.itads.conference.exception.ObjectNotFoundException;
import br.com.itads.conference.repository.SessionRepository;
import br.com.itads.conference.repository.SubscriptionRepository;
import br.com.itads.conference.service.ISessionService;

@Service
public class SessionService implements ISessionService {

	SessionRepository sessionRepository;
	SubscriptionRepository subscriptionRepository;
	
	SessionService(SessionRepository sessionRepository, SubscriptionRepository subscriptionRepository) {
		this.sessionRepository = sessionRepository;
		this.subscriptionRepository = subscriptionRepository;
	}
	
	@Override
	public String addSession(Session session) {				
		Session sessionSaver = sessionRepository.save(session);
		return sessionSaver.getUUID().toString();
	}

	@Override
	public Session getSessionDetails(String sessionId) {
		return sessionRepository.findById(UUID.fromString(sessionId))
				.orElseThrow(() -> new ObjectNotFoundException("Session not found with ID: " + sessionId));
	}

	@Override
	public String subscribeSession(Session session, User user) {
		SubscriptionID subscriptionID = new SubscriptionID(session, user);
		Subscription subscription = new Subscription(subscriptionID, 1, UUID.randomUUID());
		
		UUID uuid = UUID.randomUUID();
		
		subscription.setUniqueId(uuid);
		subscriptionRepository.save(subscription);
		
		return uuid.toString();
	}

	@Override
	public List<Session> listSessions() {
		return sessionRepository.findAll();
	}

}
