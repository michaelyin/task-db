/**
 * 
 */
package net.wyun.qys.domain.standard;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.JcrFile;

/**
 * @author michael
 *
 */
@Entity(name = "StanJcrFile")
@ExoEntity
@Table(name = "qys_stan_jcrfile")
public class StanJcrFile extends JcrFile {

	     public StanJcrFile() {	}

		//Mapping to standard_ID
	     @ManyToOne(targetEntity=Standard.class)
		 @JoinColumn(name = "standard_id")
		 protected  Standard standard;
		 
		 public Standard getStandard(){
		 	return standard;
		 }
		 
		 public void setStandard(Standard standard){
			 this.standard = standard;
		 }
	
}
