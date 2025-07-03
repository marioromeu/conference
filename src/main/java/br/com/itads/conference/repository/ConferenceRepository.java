package br.com.itads.conference.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itads.conference.domain.Conference;

@Repository
public interface ConferenceRepository extends ListCrudRepository<Conference, Long> {
}
