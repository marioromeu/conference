package br.com.itads.conference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.conference.domain.Conference;
import br.com.itads.conference.service.IConferenceService;

@RestController
public class ConferenceController {

	IConferenceService conferenceService;
	
	ConferenceController(IConferenceService conferenceService) {
		this.conferenceService = conferenceService;
	}
	
	@GetMapping(path = "/conference/{conferenceId}/isOpen")
	public Boolean isConferenceOpen(@PathVariable Long conferenceId) {
		return conferenceService.isConferenceOpen(conferenceId);
	}
	
	@PostMapping(path = "/conference")
	public Boolean addConference(@RequestBody Conference conference) {
		return conferenceService.addConference(conference);
	}
	
}
