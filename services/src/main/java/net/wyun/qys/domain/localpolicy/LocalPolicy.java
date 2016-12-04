package net.wyun.qys.domain.localpolicy;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Policy;
import net.wyun.qys.domain.nationalpolicy.NPJcrFile;
import net.wyun.qys.domain.nationalpolicy.NPTag;


@Entity(name = "LocalPolicy")
@ExoEntity
@Table(name = "qys_local_policy")
public class LocalPolicy extends Policy{
	
	 LPSourceType source;
	 LPolicyType type;
	
	 @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=LPTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<LPTag> policyTags = new HashSet<LPTag>();
	  
	  @JsonBackReference
	  @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=LPJcrFile.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<LPJcrFile> jcrFiles = new HashSet<LPJcrFile>();
	  
	  private Province province;
	  private String city;
	  

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<LPJcrFile> getJcrFiles() {
		return jcrFiles;
	}

	public void setJcrFiles(Set<LPJcrFile> jcrFiles) {
		this.jcrFiles = jcrFiles;
	}

	public LPSourceType getSource() {
		return source;
	}

	public void setSource(LPSourceType source) {
		this.source = source;
	}

	public LPolicyType getType() {
		return type;
	}

	public void setType(LPolicyType type) {
		this.type = type;
	}

	public Set<LPTag> getPolicyTags() {
		return policyTags;
	}

	public void setPolicyTags(Set<LPTag> policyTags) {
		this.policyTags = policyTags;
	}

	@Transient
	public void addLPTag(LPTag tag){
		tag.setPolicy(this);
		policyTags.add(tag);
	}
	
	@Transient
	public void addLPJcrFile(LPJcrFile f){
		f.setPolicy(this);
		jcrFiles.add(f);
	}
}
