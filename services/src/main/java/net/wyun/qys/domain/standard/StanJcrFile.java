/**
 * 
 */
package net.wyun.qys.domain.standard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.exoplatform.commons.api.persistence.ExoEntity;
import org.hibernate.annotations.GenericGenerator;

import net.wyun.qys.domain.JcrFile;

/**
 * @author michael
 *
 */
@Entity(name = "StanJcrFile")
@ExoEntity
@Table(name = "qys_stan_jcrfile", uniqueConstraints=
  @UniqueConstraint(columnNames={"stan_id", "uuid"}))
public class StanJcrFile /*extends JcrFile*/ {

	 @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid")
	    @Column(name= "id", columnDefinition = "VARCHAR(36)")
	    @Id
	  private String  id;
	
	  
	  @Column(name = "uuid", length = 36, columnDefinition="VARCHAR(36)")
	  String uuid;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_t")
	private Date uploadDate;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "file_name")
	private String fileName;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "stan_id")
	private Standard standard;

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

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
