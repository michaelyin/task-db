package net.wyun.qys.domain.nationalpolicy;

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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Policy;
import net.wyun.qys.domain.standard.StanJcrFile;
import net.wyun.qys.domain.standard.StanTag;

@Entity(name = "npolicy")
@ExoEntity
@Table(name = "qys_national_policy")
public class NationalPolicy extends Policy{
	
	 NPSourceType source;
	 NPolicyType type;
	
	 @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=StanTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<NPTag> policyTags = new HashSet<NPTag>();
	  
	  @JsonBackReference
	  @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=StanJcrFile.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<NPJcrFile> jcrFiles = new HashSet<NPJcrFile>();

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

	public Set<NPJcrFile> getJcrFiles() {
		return jcrFiles;
	}

	public void setStanJcrFiles(Set<NPJcrFile> jcrFiles) {
		this.jcrFiles = jcrFiles;
	}

}
