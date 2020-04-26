package com.mediasoft.odeks.repositories;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.mediasoft.odeks.model.JournalMaster;

public interface JournalMasterRepository extends PagingAndSortingRepository<JournalMaster,Integer>{
	@Query("select j from journalmaster j  where j.user.identifiant=:identifant")
	public List<JournalMaster> findAllByUser(@Param(value = "identifant") String identifiant);

}
