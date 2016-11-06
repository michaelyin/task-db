package net.wyun.qys.domain.standard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Tag;

@Entity(name = "StanTag")
@ExoEntity
@Table(name = "qys_stan_tag")
public class StanTag extends Tag{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "stan_id")
	private Standard standard;

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	
}
