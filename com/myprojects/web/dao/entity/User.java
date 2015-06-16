/**
 * User
 */
package com.myprojects.web.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Entity
@Table(name=IProject.USERS_TABLE)
public class User implements Serializable {
	
	private static final long serialVersionUID = 7692922918197900472L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=5, max=60, message="{User.username}")
	@Column(name="user_name")
	private String userName;
	
	@NotBlank(message="{User.password}")
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Size(min=2, max=100, message="{User.name}")
	@Column(name="name")
	private String name;
	
	//@Email(message="This does not appear to be a valid email address.")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid.")
	@Column(name="email")
	private String email;
	
	@Column(name="authority")
	private String authority;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_last_date")
	private String updatedLastDate;
	
	@Transient
	private String invalidRecaptcha;
	
	/**
	 * 
	 */
	public User() {
		this.userName = null;
		this.password = null;
		this.enabled = false;
		this.name = null;
		this.email = null;
		this.authority = null;
		this.createdDate = null;
		this.updatedLastDate = null;	
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedLastDate
	 */
	public String getUpdatedLastDate() {
		return updatedLastDate;
	}

	/**
	 * @param updatedLastDate the updatedLastDate to set
	 */
	public void setUpdatedLastDate(String updatedLastDate) {
		this.updatedLastDate = updatedLastDate;
	}

	/**
	 * @return the invalidRecaptcha
	 */
	public String getInvalidRecaptcha() {
		return invalidRecaptcha;
	}

	/**
	 * @param invalidRecaptcha the invalidRecaptcha to set
	 */
	public void setInvalidRecaptcha(String invalidRecaptcha) {
		this.invalidRecaptcha = invalidRecaptcha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", enabled=" + enabled + ", name=" + name
				+ ", email=" + email + ", authority=" + authority
				+ ", createdDate=" + createdDate + ", updatedLastDate="
				+ updatedLastDate + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((updatedLastDate == null) ? 0 : updatedLastDate.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null) {
				return false;
			}
		} else if (!authority.equals(other.authority)) {
			return false;
		}
		if (createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!createdDate.equals(other.createdDate)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (enabled != other.enabled) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (updatedLastDate == null) {
			if (other.updatedLastDate != null) {
				return false;
			}
		} else if (!updatedLastDate.equals(other.updatedLastDate)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}
}
