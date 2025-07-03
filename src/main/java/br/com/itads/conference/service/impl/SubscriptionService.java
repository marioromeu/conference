package br.com.itads.conference.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.Subscription;
import br.com.itads.conference.domain.SubscriptionID;
import br.com.itads.conference.domain.User;
import br.com.itads.conference.repository.SubscriptionRepository;
import br.com.itads.conference.service.ISubscriptionService;

@Service
public class SubscriptionService implements ISubscriptionService {

	SubscriptionRepository subscriptionRepository;
		
	SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}
	
	@Override
	public Subscription createSubscription(Subscription subscription) {
		if (subscription != null) {
			subscription.setCreatedAt(LocalDateTime.now());
			return subscriptionRepository.save(subscription);
		}
		return null;
	}

	@Override
	public List<Subscription> getSubscriptionsByUser(User user) {
		SubscriptionID subscriptionID = new SubscriptionID(null, user);
		return subscriptionRepository.findBySubscriptionID(subscriptionID);
	}

	@Override
	public List<Subscription> getSubscriptionsBySession(Session session) {
		SubscriptionID subscriptionID = new SubscriptionID(session, null);
		return subscriptionRepository.findBySubscriptionID(subscriptionID);
	}

}
