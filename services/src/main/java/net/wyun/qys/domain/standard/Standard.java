package net.wyun.qys.domain.standard;

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

import org.exoplatform.commons.api.persistence.ExoEntity;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Standard")
@ExoEntity
@Table(name = "qys_standard")
public class Standard {
	
	  public Standard() {}

	  @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid")
	    @Column(name= "id", columnDefinition = "VARCHAR(36)")
	    @Id
	  private String    id;
	  
	  private String name;
	  
	  private String num;
	  
	  private StandardType type;
	  
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name = "create_t")
	  private Date createDate;
	  
	  @Column(name = "txt_uuid")
	  private String uuid;

	  @OneToMany(mappedBy="standard", cascade={CascadeType.ALL}, targetEntity=StanTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<StanTag> stanTags = new HashSet<StanTag>();
	  
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

}
