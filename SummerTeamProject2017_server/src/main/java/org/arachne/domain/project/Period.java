package org.arachne.domain.project;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Period {

	@Temporal(TemporalType.DATE)
	private Date startedDate;
	
	
	@Temporal(TemporalType.DATE)
	private Date endedDate;
	
	
}
