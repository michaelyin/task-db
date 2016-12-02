package net.wyun.qys.domain.nationalpolicy;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Policy;

@Entity(name = "npolicy")
@ExoEntity
@Table(name = "qys_national_policy")
public class NationalPolicy extends Policy{
	
	 NPSourceType source;
	 NPolicyType type;
	
	 @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=NPTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<NPTag> policyTags = new HashSet<NPTag>();
	  
	  @JsonBackReference
	  @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=NPJcrFile.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<NPJcrFile> jcrFiles = new HashSet<NPJcrFile>();

	public Set<NPJcrFile> getJcrFiles() {
		return jcrFiles;
	}

	public void setJcrFiles(Set<NPJcrFile> jcrFiles) {
		this.jcrFiles = jcrFiles;
	}

	public NPSourceType getSource() {
		return source;
	}

	public void setSource(NPSourceType source) {
		this.source = source;
	}

	public NPolicyType getType() {
		return type;
	}

	public void setType(NPolicyType type) {
		this.type = type;
	}

	public Set<NPTag> getPolicyTags() {
		return policyTags;
	}

	public void setPolicyTags(Set<NPTag> policyTags) {
		this.policyTags = policyTags;
	}


}
