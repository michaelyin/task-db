/**
 * 
 */
package net.wyun.qys.domain.localpolicy;

import java.io.Serializable;
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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.exoplatform.commons.api.persistence.ExoEntity;
import org.hibernate.annotations.GenericGenerator;

import net.wyun.qys.domain.JcrFile;
import net.wyun.qys.domain.JcrFileType;

/**
 * @author michael
 *
 */
@Entity(name = "LPJcrFile")
@ExoEntity
@Table(name = "qys_lp_jcrfile", uniqueConstraints=
  @UniqueConstraint(columnNames={"lp_id", "uuid"}))
public class LPJcrFile implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 5126381948415234106L;


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
	
	private String url;
	
	@Column(name = "file_name")
	private String fileName;
	
	@JsonManagedReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "lp_id")
	private LocalPolicy policy;

	private JcrFileType type;

	public JcrFileType getType() {
		return type;
	}

	public void setType(JcrFileType type) {
		this.type = type;
	}

	public LocalPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(LocalPolicy policy) {
		this.policy = policy;
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

	@Override
	public String toString() {
		return "{'fileName':'" + fileName + "','uuid':'" + uuid + "'}";
	}
}
