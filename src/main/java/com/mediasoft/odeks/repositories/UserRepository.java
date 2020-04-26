package com.mediasoft.odeks.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.User;

public interface UserRepository extends CrudRepository<User, Integer>  {
	@Query("select u from users u where u.identifiant=:identifiant")
    Optional<User> findOneByIdentifiant(@Param(value="identifiant") String identifiant);
	@Query("SELECT j FROM users u JOIN u.journalMasters j WHERE j.user.id =:idUser AND j.id = :idJournal")
	JournalMaster findJournalByIdForUser(@Param(value="idJournal") Integer idJournal,@Param(value="idUser") Integer idUser);
	@Query("SELECT u FROM users u where u.name =:name")
	Optional<User> findOneByName(@Param(value="name") String name);
}
