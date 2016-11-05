package net.wyun.qys.domain.standard;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.TagId;

@Entity(name = "StanTag")
@ExoEntity
@Table(name = "stan_tag")
public class StanTag {
	
	  @EmbeddedId
	  private TagId id;
	  
	  @ManyToOne
	  @JoinColumn(name = "standard_id",insertable = false, updatable = false)
	  private Standard standard;

		public TagId getId() {
			return id;
		}
	
		public void setId(TagId id) {
			this.id = id;
		}
	
		public Standard getStandard() {
			return standard;
		}
	
		public void setStandard(Standard standard) {
			this.standard = standard;
		}
	 

}
