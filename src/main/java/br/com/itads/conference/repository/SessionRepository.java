package br.com.itads.conference.repository;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itads.conference.domain.Session;

@Repository
public interface SessionRepository extends ListCrudRepository<Session, UUID> {

}
