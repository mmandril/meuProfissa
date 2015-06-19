package br.com.pto.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.com.pto.model.entity.User;

@SessionScoped
public class SessionVariables implements Serializable {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}