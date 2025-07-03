package br.com.itads.conference.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.conference.controller.dto.SessionDTO;
import br.com.itads.conference.controller.dto.SubscribeDTO;
import br.com.itads.conference.domain.Session;
import br.com.itads.conference.service.ISessionService;

@RestController
public class SessionController {

	ISessionService sessionService;
	
	SessionController(ISessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	@GetMapping(path = "/session/{uuid}")
	public Session getSessionDetails(String uuid) {
		return sessionService.getSessionDetails(uuid);
	}

	@GetMapping(path = "/sessions")
	public List<Session> listSessions() {
		return sessionService.listSessions();
	}
	
	@PostMapping(path = "/session")
	public String addSession(@RequestBody SessionDTO sessionDTO) {		
		Session session = sessionDTO.toDomain();		
		return sessionService.addSession(session);
	}
	
	@PostMapping(path = "/subscribe")
	public String  subscribeSession(@RequestBody SubscribeDTO subscribeDTO) {
		
		if (subscribeDTO.session() == null || subscribeDTO.user() == null) {
			throw new IllegalArgumentException("Session and User cannot be null");
		}
		return sessionService.subscribeSession(
				subscribeDTO.session(), 
				subscribeDTO.user()
		);
	}
	
}
