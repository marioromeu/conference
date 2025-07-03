package br.com.itads.conference.controller.dto;

import br.com.itads.conference.domain.Session;
import br.com.itads.conference.domain.User;

public record SubscribeDTO(Session session, User user) {	
}