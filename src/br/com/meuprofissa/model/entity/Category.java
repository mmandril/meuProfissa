package br.com.meuprofissa.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "altered", nullable = true, length = 19)
	private Date altered;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inactived", nullable = true, length = 19)
	private Date inactived;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<SubCategory> subCategorys = new HashSet<SubCategory>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getAltered() {
		return altered;
	}

	public void setAltered(Date altered) {
		this.altered = altered;
	}

	public Date getInactived() {
		return inactived;
	}

	public void setInactived(Date inactived) {
		this.inactived = inactived;
	}

	public Set<SubCategory> getSubCategorys() {
		return subCategorys;
	}

	public void setSubCategorys(Set<SubCategory> subCategorys) {
		this.subCategorys = subCategorys;
	}

}