package net.wyun.qys.domain.standard;

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

@Entity(name = "Standard")
@ExoEntity
@Table(name = "qys_standard")
public class Standard {
	
	  public Standard() {}

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO) //, generator="SEQ_QYS_POLICY_ID"), use mysql default sequence
	  @Column(name = "standard_id")
	  private long        id;
	  
	  @Column(name = "standard_name")
	  private String standardName;
	  
	  @Column(name = "standard_num")
	  private String standardNum;
	  
	  @Column(name = "STANDARD_TYPE", nullable = false)
	  private StandardType standardType;
	  
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "create_date")
	  private Date createDate;
	  
	  @Column(name = "text")
	  private String text;

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getStandardNum() {
		return standardNum;
	}

	public void setStandardNum(String standardNum) {
		this.standardNum = standardNum;
	}

	public StandardType getStandardType() {
		return standardType;
	}

	public void setStandardType(StandardType standardType) {
		this.standardType = standardType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
