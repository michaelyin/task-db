package net.wyun.qys.domain.nationalpolicy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.commons.api.persistence.ExoEntity;

import net.wyun.qys.domain.Policy;

@Entity(name = "npolicy")
@ExoEntity
@Table(name = "qys_national_policy")
public class NationalPolicy extends Policy{
	
	  

}
