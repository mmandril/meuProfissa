package br.com.meuprofissa.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", nullable = false)
	private Profile profile;
	
	@Column(name="login", nullable = false)
	private String login;
	
	@Column(name="password", nullable = false)
	private String password;

	@Column(name="signup_token")
	private String signupToken;
	
	@Column(name="login_token")
	private String loginToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "altered", nullable = true, length = 19)
	private Date altered;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inactived", nullable = true, length = 19)
	private Date inactived;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignupToken() {
		return signupToken;
	}

	public void setSignupToken(String signupToken) {
		this.signupToken = signupToken;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
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
}