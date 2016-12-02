package net.wyun.qys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.commons.api.persistence.ExoEntity;
import org.hibernate.annotations.GenericGenerator;

@Entity() 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public abstract class Policy {
	
	  @Id
	  @GeneratedValue(generator = "uuid-gen")
	  @GenericGenerator(name = "uuid-gen",  strategy = "uuid2")
      @Column(name = "id", updatable = false, nullable = false)
	  private String   id;
	  
	  private String name;
	  
      private String num;
	  
	  //private StandardType type; //sub class
	  
	  private String creator;
	  
	  private String department;
	  
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "create_t")
	  private Date createDate;
	  
	  @Column(name = "txt_uuid")
	  private String t_uuid;
	  
	  @Column(name = "exp_uuid")
	  private String e_uuid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getT_uuid() {
		return t_uuid;
	}

	public void setT_uuid(String t_uuid) {
		this.t_uuid = t_uuid;
	}

	public String getE_uuid() {
		return e_uuid;
	}

	public void setE_uuid(String e_uuid) {
		this.e_uuid = e_uuid;
	}

}
