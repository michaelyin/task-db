package net.wyun.qys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity(name = "Policy")
@ExoEntity
@Table(name = "QYS_POLICY")
public class Policy {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO) //, generator="SEQ_QYS_POLICY_ID"), use mysql default sequence
	  @Column(name = "POLICY_ID")
	  private long        id;
	  
	  @Column(name = "POLICY_NAME")
	  private String policyName;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "START_DATE")
	  private Date startDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
