package org.arachne.domain.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;

import lombok.Data;

@Entity
@Data
public class PrjSchedule {

	
	@Id
	@GeneratedValue
	@Column(name="prj_schj_id")
	private Long id;
	
	//20171107 수정함 
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	
	@Embedded
	private Period period;
	
	@OneToMany
	@JoinColumn(name="prj_mem_id")
	private List<PrjMember> associatedMembers=new ArrayList<>();
	
	@Max(255)
	private String descrption;
	
	@Enumerated(EnumType.STRING)
	private SchjState schjState;
	
}
