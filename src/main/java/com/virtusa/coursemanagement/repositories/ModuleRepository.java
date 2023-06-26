package com.virtusa.coursemanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.coursemanagement.models.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{

	List<Module> findByCourseId(Long id);

}
