package br.com.itads.conference.service;

import java.util.List;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.Subscription;
import br.com.itads.conference.domain.User;

public interface ISubscriptionService {

	public Subscription createSubscription(Subscription subscription);

	public List<Subscription> getSubscriptionsByUser(User user);

	public List<Subscription> getSubscriptionsBySession(Session session);

}
