package net.wyun.qys.domain.standard;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.exoplatform.commons.api.persistence.ExoEntity;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Standard")
@ExoEntity
@Table(name = "qys_standard")
public class Standard {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -1092818647002847041L;
	

	public Standard() {}

	  @Id
	  @GeneratedValue(generator = "uuid-gen")
	  @GenericGenerator(name = "uuid-gen",  strategy = "uuid2")
      @Column(name = "id", updatable = false, nullable = false)
	  private String    id;
	  
	  private String name;
	  
	  private String num;
	  
	  private StandardType type;
	  
	  private String creator;
	  
	  private String department;
	  
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "create_t")
	  private Date createDate;
	  
	  @Column(name = "txt_uuid")
	  private String uuid;

	  @JsonBackReference
	  @OneToMany(mappedBy="standard", cascade={CascadeType.ALL}, targetEntity=StanTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<StanTag> stanTags = new HashSet<StanTag>();
	  
	  @JsonBackReference
	  @OneToMany(mappedBy="standard", cascade={CascadeType.ALL}, targetEntity=StanJcrFile.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<StanJcrFile> stanJcrFiles = new HashSet<StanJcrFile>();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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

	public StandardType getType() {
		return type;
	}

	public void setType(StandardType type) {
		this.type = type;
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

	public Set<StanTag> getStanTags() {
		return stanTags;
	}

	public void setStanTags(Set<StanTag> stanTags) {
		this.stanTags = stanTags;
	}
	
	@Transient
	public void addStanTag(StanTag tag){
		tag.setStandard(this);
		stanTags.add(tag);
	}
	
	@Transient
	public void addStanJcrFile(StanJcrFile f){
		f.setStandard(this);
		stanJcrFiles.add(f);
	}

	public Set<StanJcrFile> getStanJcrFiles() {
		return stanJcrFiles;
	}

	public void setStanJcrFiles(Set<StanJcrFile> stanJcrFiles) {
		this.stanJcrFiles = stanJcrFiles;
	}

	@Override
	public String toString() {
		return "Standard [id=" + id + ", name=" + name + ", num=" + num + ", type=" + type + ", creator=" + creator
				+ ", department=" + department + ", createDate=" + createDate + ", uuid=" + uuid + ", stanTags="
				+ stanTags + ", stanJcrFiles=" + stanJcrFiles + "]";
	}

}
