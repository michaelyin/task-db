package net.wyun.qys.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity() 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public abstract class Tag {
	

	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name= "id", columnDefinition = "VARCHAR(36)")
    @Id
	protected String id;
 
    @Column(name = "tag")
    protected String tag;
 
    public Tag() {
    }
 
    public Tag(String id, String tag) {
        this.id = id;
        this.tag = tag;
    }
 
    public String getId() {
        return id;
    }
 
    public String getTag() {
        return tag;
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return "{'id':'" + id + "', 'tag:'" + tag + "'}";
	}
 
}
