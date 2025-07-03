package br.com.itads.conference.service;

import br.com.itads.conference.domain.Conference;

public interface IConferenceService {

	Boolean addConference(Conference conference);

	Boolean isConferenceOpen(Long conferenceId);

}
