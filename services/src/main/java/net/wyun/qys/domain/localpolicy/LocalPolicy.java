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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Policy;
import net.wyun.qys.domain.nationalpolicy.NPJcrFile;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NPTag;
import net.wyun.qys.domain.nationalpolicy.NPolicyType;
import net.wyun.qys.domain.standard.StanJcrFile;
import net.wyun.qys.domain.standard.StanTag;

@Entity(name = "lpolicy")
@ExoEntity
@Table(name = "qys_local_policy")
public class LocalPolicy extends Policy{
	
	 LPSourceType source;
	 LPolicyType type;
	
	 @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=StanTag.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<LPTag> policyTags = new HashSet<LPTag>();
	  
	  @JsonBackReference
	  @OneToMany(mappedBy="policy", cascade={CascadeType.ALL}, targetEntity=StanJcrFile.class, fetch=FetchType.EAGER)
	  //@JoinColumn(name="stan_id", referencedColumnName="id")
	  private Set<LPJcrFile> stanJcrFiles = new HashSet<LPJcrFile>();

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

	public Set<LPJcrFile> getStanJcrFiles() {
		return stanJcrFiles;
	}

	public void setStanJcrFiles(Set<LPJcrFile> stanJcrFiles) {
		this.stanJcrFiles = stanJcrFiles;
	}

}
