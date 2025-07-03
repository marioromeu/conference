package br.com.itads.conference.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itads.conference.domain.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {

}
