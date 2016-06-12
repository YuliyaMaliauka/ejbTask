package classes.by.gsu.epamlab.beans;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private Role role;

	public User() {
		super();
	}
	
	public User(String name){
		this.name = name;
		this.role = Role.USER;
	}

	public User(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + "]";
	}
	
}
