package br.com.itads.conference.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.Subscription;
import br.com.itads.conference.domain.User;
import br.com.itads.conference.service.ISubscriptionService;

@RestController
public class SubscriptionController {

	ISubscriptionService subscriptionService;
	
	SubscriptionController(ISubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	@PostMapping(path = "/subscription")
	public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
		return ResponseEntity.ok(subscriptionService.createSubscription(subscription));
	}
	
	@GetMapping(path = "/subscription/user/{userId}")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsByUserId(@PathVariable Long userId) {
		User user = new User(userId, null, null, null);
		return ResponseEntity.ok(subscriptionService.getSubscriptionsByUser(user));
	}
	
	@GetMapping(path = "/subscription/session/{sessionId}")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsBySessionId(@PathVariable String sessionId) {
		Session session = new Session(UUID.fromString(sessionId), null, null, null);
		return ResponseEntity.ok(subscriptionService.getSubscriptionsBySession(session));
	}
	
}
