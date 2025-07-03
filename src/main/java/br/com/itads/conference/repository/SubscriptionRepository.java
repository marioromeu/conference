package br.com.itads.conference.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import br.com.itads.conference.domain.Subscription;
import br.com.itads.conference.domain.SubscriptionID;

public interface SubscriptionRepository extends ListCrudRepository<Subscription, SubscriptionID> {

	public List<Subscription> findBySubscriptionID(SubscriptionID subscriptionID);
	
}
