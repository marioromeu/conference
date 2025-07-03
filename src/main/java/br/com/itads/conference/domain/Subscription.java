package br.com.itads.conference.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription {
	
	@Id
	private SubscriptionID subscriptionID;
	
	@Column(name = "level", nullable = false, unique = false)
	private Integer level;
	
	@Column(name = "created_at", nullable = false, unique = false)
	private LocalDateTime createdAt;
	
	@Column(name = "unique_id", nullable = true, unique = true)
	private UUID uniqueId;
	
	public Subscription() {
		super();
	}
	
	public Subscription(SubscriptionID subscriptionID, Integer level, UUID uniqueId) {
		this.subscriptionID = subscriptionID;
		this.level = level;
		this.createdAt = LocalDateTime.now();
		this.uniqueId = uniqueId;
	}
	
	public SubscriptionID getSubscriptionID() {
		return subscriptionID;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime now) {
		this.createdAt = now;
	}

 	public UUID getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(UUID uuid) {
		this.uniqueId = uuid;		
	}

}