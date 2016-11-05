package net.wyun.qys.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TagId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
    private Long id;
 
    @Column(name = "tag")
    private String tag;
 
    public TagId() {
    }
 
    public TagId(Long id, String tag) {
        this.id = id;
        this.tag = tag;
    }
 
    public Long getId() {
        return id;
    }
 
    public String getTag() {
        return tag;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TagId)) return false;
        TagId that = (TagId) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTag(), that.getTag());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTag());
    }

}
