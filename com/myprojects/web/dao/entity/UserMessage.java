/**
 * UserMessage
 */
package com.myprojects.web.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.myprojects.web.utility.MyProjectsUtility;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Entity
@Table(name=IProject.USER_MESSAGES_TABLE)
public class UserMessage {

	@Id
	@GeneratedValue
	private int id;

	@Size(min=2, max=60, message="{UserMessage.sendee}")
	@Column(name="sendee")
	private String sendee;
	
	@Size(min=2, max=60, message="{UserMessage.sender}")
	@Column(name="sender")
	private String sender;
	
	@Size(min=2, max=60, message="{UserMessage.subject}")
	@Column(name="subject")
	private String subject;
	
	@Size(min=2, max=140, message="{UserMessage.message}")
	@Column(name="message")
	private String message;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="active")
	private String active;

	/**
	 * 
	 */
	public UserMessage() {
		this.id = -1;
		this.sendee = "";
		this.sender = "";
		this.subject = "";
		this.message = "";
		this.createdDate = "";
		this.active = "";
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
	 * @return the sendee
	 */
	public String getSendee() {
		return sendee;
	}

	/**
	 * @param sendee the sendee to set
	 */
	public void setSendee(String sendee) {
		this.sendee = sendee;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return MyProjectsUtility.truncateMSFromDateString(createdDate);
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserMessage [id=" + id + ", subject=" + subject + ", message="
				+ message + ", createdDate=" + createdDate + ", active="
				+ active + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		if (!(obj instanceof UserMessage)) {
			return false;
		}
		UserMessage other = (UserMessage) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (createdDate == null) {
			if (other.createdDate != null) {
				return false;
			}
		} else if (!createdDate.equals(other.createdDate)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		if (subject == null) {
			if (other.subject != null) {
				return false;
			}
		} else if (!subject.equals(other.subject)) {
			return false;
		}
		return true;
	}
}
