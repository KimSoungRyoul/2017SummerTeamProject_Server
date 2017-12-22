package org.arachne.presentation.restapi.project;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projects/schedules")
public class PrjScheduleAPI {

	//프로젝트 스케줄 조회
	@GetMapping
	public ResponseEntity<Map<String, Object>> GETPrjSchedues(){
		
		return null;
	}
	
}
