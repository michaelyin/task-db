/**
 * 
 */
package net.wyun.qys.domain.standard;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.JcrFile;

/**
 * @author michael
 *
 */
@Entity(name = "stanJcrFile")
@ExoEntity
@Table(name = "QYS_STAN_JCRFILE")
public class StanJcrFile extends JcrFile {

	
}
