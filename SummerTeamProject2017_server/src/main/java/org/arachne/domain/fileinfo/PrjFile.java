package org.arachne.domain.fileinfo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.arachne.domain.project.FileType;
import org.arachne.domain.project.PrjMember;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("prj")
@PrimaryKeyJoinColumn(name="prj_file_id")
@Data
@EqualsAndHashCode(callSuper=false)
public class PrjFile extends FileInfo{
	
	
	
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private PrjMember uploader;
	
	@Enumerated
	private FileType type;
	
	
	
	
}
