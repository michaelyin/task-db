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
@Table(name = "QYS_STANDARD")
public class Standard {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO) //, generator="SEQ_QYS_POLICY_ID"), use mysql default sequence
	  @Column(name = "STANDARD_ID")
	  private long        id;
	  
	  @Column(name = "STANDARD_NAME")
	  private String standardName;
	  
	  @Column(name = "STANDARD_NUM")
	  private String standardNum;
	  
	  @Column(name = "STANDARD_TYPE", nullable = false)
	  private StandardType standardType;
	  
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "CREATE_DATE")
	  private Date createDate;
	  
	  

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
