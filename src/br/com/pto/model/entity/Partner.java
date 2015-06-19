package br.com.pto.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partner")
public class Partner {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_type_id", nullable = false)
	private PartnerType partnerType;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="fantasy_name")
	private String fantasyName;
	
	@Column(name="contact1")
	private String contact1;
	
	@Column(name="contact2")
	private String contact2;
	
	@Column(name="contact3")
	private String contact3;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "partner_subcategory", joinColumns = { 
			@JoinColumn(name = "partner_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "subcategory_id", 
					nullable = false, updatable = false) })
	private Set<SubCategory> subCategorys =  new HashSet<SubCategory>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PartnerType getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(PartnerType partnerType) {
		this.partnerType = partnerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getContact3() {
		return contact3;
	}

	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}

	public Set<SubCategory> getSubCategorys() {
		return subCategorys;
	}

	public void setSubCategorys(Set<SubCategory> subCategorys) {
		this.subCategorys = subCategorys;
	}
}