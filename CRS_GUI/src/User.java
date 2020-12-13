import java.io.Serializable;

public class User implements Serializable {
	protected String username, password, fname, lname;

	public User(String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}
	public User() {
		
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	
}