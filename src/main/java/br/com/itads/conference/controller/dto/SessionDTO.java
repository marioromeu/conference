package br.com.itads.conference.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.itads.conference.domain.Conference;
import br.com.itads.conference.domain.Session;

public class SessionDTO {

	private String title;	
	private LocalDateTime dateTime;	
	private Integer conferenceId;

	public SessionDTO(String title, LocalDateTime dateTime, Integer conferenceId) {
		super();
		UUID.randomUUID().toString();
		this.title = title;
		this.dateTime = dateTime;
		this.conferenceId = conferenceId;
	}

	public Session toDomain() {
		Conference conference = new Conference(Long.valueOf(this.conferenceId), null, null);
		return new Session(null, this.title, this.dateTime, conference);
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Integer getConferenceId() {
		return conferenceId;
	}
	
}
