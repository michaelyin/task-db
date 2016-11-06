package net.wyun.qys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.InheritanceType;

@Entity() 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public abstract class JcrFile {
	
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name= "id", columnDefinition = "VARCHAR(36)")
    @Id
	private String id;
	
	  
	  @Column(name = "uuid", length = 36, columnDefinition="VARCHAR(36)")
	  String uuid;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_t")
	private Date uploadDate;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "file_name")
	private String fileName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
