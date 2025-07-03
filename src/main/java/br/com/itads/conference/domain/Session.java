package br.com.itads.conference.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class Session {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
	private UUID uuid;
	
	@Column(name = "title", nullable = false, unique = false)
	private String title;
	
	@Column(name = "date_time", nullable = false, unique = false)
	private LocalDateTime dateTime;	
	
	@ManyToOne
	@JoinColumn(name = "conference_id", nullable = false, unique = false)
	private Conference conference;

	public Session() {
		super();
	}
	
	public Session(UUID uuid, String title, LocalDateTime dateTime, Conference conference) {
		super();
		this.uuid = uuid;
		this.title = title;
		this.dateTime = dateTime;
		this.conference = conference;
	}

	public UUID getUUID() {
		return uuid;
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Conference getConference() {
		return conference;
	}

}
