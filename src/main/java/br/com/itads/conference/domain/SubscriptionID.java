package br.com.itads.conference.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SubscriptionID {
	
	@ManyToOne
	@JoinColumn(name = "subscription_session_id")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name = "subscription_user_id")
	private User user;
	
	public SubscriptionID() {
		super();
	}
	
	public SubscriptionID(Session session, User user) {
		this.session = session;
		this.user = user;
	}
	
	public Session getSession() {
		return session;
	}
	
	public User getUser() {
		return user;
	}

}