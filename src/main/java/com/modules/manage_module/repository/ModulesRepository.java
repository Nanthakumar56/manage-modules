package com.modules.manage_module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.modules.manage_module.entity.Modules;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, String> {

	@Query("SELECT m from Modules m WHERE m.projectid =:projectId")
	List<Modules> findAllById(String projectId);

	
}
