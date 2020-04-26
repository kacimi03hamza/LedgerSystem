package com.mediasoft.odeks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mediasoft.odeks.model.ProjectIdentifier;
public interface ProjectIdentifierRepository extends CrudRepository<ProjectIdentifier, Integer> {
	 @Query("SELECT c from projectidentifier c WHERE c.projectCode LIKE %:code%")
	 public List<ProjectIdentifier> serachByCode(@Param(value = "code") String code);
	 @Query("SELECT c from projectidentifier c WHERE c.projectCode = :code")
	 public List<ProjectIdentifier> getByCode(@Param(value = "code") String code);
}
