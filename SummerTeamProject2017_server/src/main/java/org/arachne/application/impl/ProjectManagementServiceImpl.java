package org.arachne.application.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.arachne.application.ProjectManagementService;
import org.arachne.domain.project.Project;
import org.arachne.infrastructure.repository.mariadb.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ProjectManagementServiceImpl implements ProjectManagementService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	@Transactional
	public void registerProject(Project project) {
		// TODO Auto-generated method stub

		try {

			projectRepository.save(project);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("프로젝트 등록 실패..............");

		}

	}

	@Override
	public void withdrawProject(Long id) {
		// TODO Auto-generated method stub

		try {

			projectRepository.delete(id);

		} catch (Exception e) {
			// TODO: handle exception

			log.error("프로젝트 삭제 실패 ...............");
		}

	}

	
	//자신이 프로젝트 리더로 있는 프로젝트 목록 불러오기
	@Transactional
	@Override
	public List<Project> requestMem_s_ProjectList(String email) {
		// TODO Auto-generated method stub

		try {

			return  projectRepository.findByProjectLeaderMAccountEmail(email);

		} catch (Exception e) {
			// TODO: handle exception

			log.error("프로젝트 삭제 실패 ...............");
			
			return null;
			
		}

		
	}

}
