package org.arachne.application;

import java.util.List;

import org.arachne.domain.project.Project;

public interface ProjectManagementService {
	
	//프로젝트 등록
	void registerProject(Project project);
	
	//프로젝트 해체
	void withdrawProject(Long id);
	
	
	//특정 회원 프로젝트 목록 요청
	List<Project> requestMem_s_ProjectList(String email);
	
	//
	
	
	
}
