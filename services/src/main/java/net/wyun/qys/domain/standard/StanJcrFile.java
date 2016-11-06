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

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.JcrFile;

/**
 * @author michael
 *
 */
@Entity(name = "StanJcrFile")
@ExoEntity
@Table(name = "qys_stan_jcrfile")
public class StanJcrFile /*extends JcrFile*/ {

	 @Id
	  @GeneratedValue(strategy=GenerationType.TABLE) //, generator="SEQ_QYS_POLICY_ID"), use mysql default sequence
	  @Column(name = "id")
	  private long  id;
	
	  
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
