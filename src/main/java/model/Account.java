package model;

public class Account  {

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	String id, name, password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getPassword() {
		return password;
	}
	

	public Account(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}




	
	
}
