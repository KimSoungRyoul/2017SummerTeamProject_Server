package org.arachne.domain.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class PrjMemo {

	
	@Id
	@GeneratedValue
	@Column(name="prj_memo_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	
	@ManyToOne
	@JoinColumn(name="prj_mem_id")
	private PrjMember memoOwer;
	
	
	@Embedded
	private Period period;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	
	
	private String text;
	
	
}
