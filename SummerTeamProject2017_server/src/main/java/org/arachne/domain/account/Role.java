package org.arachne.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;


@Entity
@Data
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="email", insertable=true,updatable=true)
	private MemberAccount authAccount;
	
	@Enumerated(EnumType.STRING)
	private AuthorityType authorityType;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authAccount.getEmail();
	}
	
	
	
	public void setMemberAccount(MemberAccount authAccount){
		
		this.authAccount=authAccount;
		
		if(authAccount.getAuthorities().contains(authAccount)){
			authAccount.getAuthorities().remove(this);
		}
		
	}
	
	@Override
    public String toString() {
        return ToStringBuilder
            .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}
