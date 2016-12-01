package net.wyun.qys.domain.localpolicy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Tag;

@Entity(name = "LPTag")
@ExoEntity
@Table(name = "qys_lp_tag", uniqueConstraints=
       @UniqueConstraint(columnNames={"lp_id", "tag"}))
public class LPTag extends Tag implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4344041960135422648L;
	
	@JsonManagedReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "lp_id")
	private LocalPolicy policy;

	public LocalPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(LocalPolicy policy) {
		this.policy = policy;
	}

	
}
