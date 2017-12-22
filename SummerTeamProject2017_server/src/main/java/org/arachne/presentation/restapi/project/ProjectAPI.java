package org.arachne.presentation.restapi.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.arachne.application.ProjectManagementService;
import org.arachne.domain.dto.HttpStateDTO;
import org.arachne.domain.dto.HttpStateDTOFactory;
import org.arachne.domain.project.PrjMember;
import org.arachne.domain.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping(value = "/api/projects")
@Log4j
public class ProjectAPI {

	@Autowired
	private ProjectManagementService prjManagmentService;

	// 프로젝트 등록
	// 권한 Role_NORMAL_USER
	@PostMapping
	public ResponseEntity<Map<String, Object>> registerProject(@RequestBody Project project) {

		ResponseEntity<Map<String, Object>> response = null;
		Map<String, Object> result = new HashMap<>();

		try {

			prjManagmentService.registerProject(project);

			result.put("state", HttpStateDTOFactory.get200());

			response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			// TODO: handle exception

			result.put("state", HttpStateDTOFactory.get400());
			response = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		}

		return response;
	}

	// 프로젝트 해체
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> dismantleProject() {
			
		return null;
	}

	

}
