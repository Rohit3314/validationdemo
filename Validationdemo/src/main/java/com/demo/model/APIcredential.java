package com.demo.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class APIcredential
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int credentialid;

	@Column
	@Size(min=4,max=8)
	private String credentialname;
	
	@Email
	private String credentialemail;
	
	@NotNull
	private String credentialpswd;
	
	@Pattern(regexp="^(admin|user)$")
	private String credentialrole;

	private boolean isactive=true;

	public APIcredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APIcredential(int credentialid, String credentialname, String credentialemail, String credentialpswd,
			String credentialrole, boolean isactive) {
		super();
		this.credentialid = credentialid;
		this.credentialname = credentialname;
		this.credentialemail = credentialemail;
		this.credentialpswd = credentialpswd;
		this.credentialrole = credentialrole;
		this.isactive = isactive;
	}

	public int getCredentialid() {
		return credentialid;
	}

	public void setCredentialid(int credentialid) {
		this.credentialid = credentialid;
	}

	public String getCredentialname() {
		return credentialname;
	}

	public void setCredentialname(String credentialname) {
		this.credentialname = credentialname;
	}

	public String getCredentialemail() {
		return credentialemail;
	}

	public void setCredentialemail(String credentialemail) {
		this.credentialemail = credentialemail;
	}

	public String getCredentialpswd() {
		return credentialpswd;
	}

	public void setCredentialpswd(String credentialpswd) {
		this.credentialpswd = credentialpswd;
	}

	public String getCredentialrole() {
		return credentialrole;
	}

	public void setCredentialrole(String credentialrole) {
		this.credentialrole = credentialrole;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "APIcredential [credentialid=" + credentialid + ", credentialname=" + credentialname
				+ ", credentialemail=" + credentialemail + ", credentialpswd=" + credentialpswd + ", credentialrole="
				+ credentialrole + ", isactive=" + isactive + "]";
	}
	
	
	
}






