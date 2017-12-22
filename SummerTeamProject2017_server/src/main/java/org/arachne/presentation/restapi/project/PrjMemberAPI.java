package org.arachne.presentation.restapi.project;

import java.util.Map;
import java.util.Set;

import org.arachne.domain.project.PrjMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projects/members")
public class PrjMemberAPI {

	
	//프로젝트 내 회원 조회
	@GetMapping
	public ResponseEntity<Map<String, Object>> GETPrjMemberList(){
		
		
		return null;
	}
	
	
	
	// 프로젝트 회원 참여
	@PostMapping
	public ResponseEntity<Map<String, Object>> registerPrjMember(@RequestBody Set<PrjMember> members) {

		return null;
	}

	// 프로젝트 회원 탈퇴
	@PutMapping
	public ResponseEntity<Map<String, Object>> withdrawalFromProject(String userEmail, Long projectId) {

		return null;
	}

}
