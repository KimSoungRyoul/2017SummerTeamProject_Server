package org.arachne.infrastructure.repository.mariadb;

import java.util.List;

import org.arachne.domain.project.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
	
	Project findByProjectLeaderId(Long id);
	
	List<Project> findByProjectLeaderMAccountEmail(String email);
	

}
