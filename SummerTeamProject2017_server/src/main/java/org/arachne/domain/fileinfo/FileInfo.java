package org.arachne.domain.fileinfo;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="fileType")
@Data
public abstract class FileInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	
	
	private String fileLocation;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	
	
	
}
