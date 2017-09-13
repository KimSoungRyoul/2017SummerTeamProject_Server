package org.arachne.domain.project;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue
	@Column(name="project_id")
	private Long id;
	
	@Length(max=225)
	private String projectName;
	
	
	@OneToOne
	@JoinColumn(name="prj_mem_id")
	PrjMember projectLeader;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	
	@OneToMany
	@JoinColumn(name="prj_mem_id")
	private Set<PrjMember> projectMembers=new HashSet<>();
	
	
	
}
