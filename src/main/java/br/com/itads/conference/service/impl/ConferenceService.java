package br.com.itads.conference.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.itads.conference.domain.Conference;
import br.com.itads.conference.repository.ConferenceRepository;
import br.com.itads.conference.service.IConferenceService;

@Service
public class ConferenceService implements IConferenceService {

	ConferenceRepository conferenceRepository;
	
	ConferenceService(ConferenceRepository conferenceRepository) {
		this.conferenceRepository = conferenceRepository;
	}
	
	@Override
	public Boolean addConference(Conference conference) {		
		return conferenceRepository.save(conference) != null;
	}

	@Override
	public Boolean isConferenceOpen(Long conferenceId) {
		Optional<Conference> conference = conferenceRepository.findById(conferenceId);
		if (conference.isPresent()) {
			return conference.get().isOpen();
		}
		return null;
	}

}
