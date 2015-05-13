/**
 * Project
 */
package com.myprojects.web.dao.entity;

import java.io.Serializable;

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
@Table(name=IProject.PROJECTS_TABLE)
public class Project implements Serializable {

	private static final long serialVersionUID = 2673364556310073985L;

	@Id
	@GeneratedValue
	private int id;

	@Size(min=5, max=45, message="{Project.name}")
	@Column(name="project_name")
	private String projectName;
	
	@Size(min=2, max=60, message="{Project.owner}")
	@Column(name="project_owner")
	private String projectOwner;
	
	@Size(min=5, max=256, message="{Project.summary}")
	@Column(name="project_short_description")
	private String projectShortDescription;

	@Size(min=10, message="{Project.goals}")
	@Column(name="goals_objectives")
	private String goalsObjectives;

	@Size(min=10, message="{Project.deliverables}")
	@Column(name="deliverables")
	private String deliverables;

	@Size(min=10, message="{Project.target.audience}")
	@Column(name="target_audience")
	private String targetAudience;

	@Column(name="cost_estimate")
	private String costEstimate;

	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_last_date")
	private String updatedLastDate;
	
	@Column(name="active")
	private String active;

	/**
	 * 
	 */
	public Project() {
		this.projectName = null;
		this.projectOwner = null;
		this.projectShortDescription = null;
		this.goalsObjectives = null;
		this.deliverables = null;
		this.targetAudience = null;
		this.costEstimate = null;
		this.createdDate = null;
		this.updatedLastDate = null;
		this.active = null;
	}

	/**
	 * 
	 * @param id
	 */
	public Project(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 
	 * @return
	 */
	public String getProjectOwner() {
		return projectOwner;
	}

	/**
	 * 
	 * @param projectOwner
	 */
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	/**
	 * 
	 * @return
	 */
	public String getProjectShortDescription() {
		return projectShortDescription;
	}

	/**
	 * 
	 * @param projectShortDescription
	 */
	public void setProjectShortDescription(String projectShortDescription) {
		this.projectShortDescription = projectShortDescription;
	}

	/**
	 * 
	 * @return
	 */
	public String getCreatedDate() {
		// Date plus 24-hour time
		return MyProjectsUtility.truncateMSFromDateString(createdDate);
	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getUpdatedLastDate() {
		// Date plus 24-hour time
		return MyProjectsUtility.truncateMSFromDateString(updatedLastDate);
	}

	/**
	 * 
	 * @param updatedLastDate
	 */
	public void setUpdatedLastDate(String updatedLastDate) {
		this.updatedLastDate = updatedLastDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getActive() {
		return active;
	}
	
	/**
	 * 
	 * @param active
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
	/**
	 * @return the goalsObjectives
	 */
	public String getGoalsObjectives() {
		return goalsObjectives;
	}

	/**
	 * @param goalsObjectives the goalsObjectives to set
	 */
	public void setGoalsObjectives(String goalsObjectives) {
		this.goalsObjectives = goalsObjectives;
	}

	/**
	 * @return the deliverables
	 */
	public String getDeliverables() {
		return deliverables;
	}

	/**
	 * @param deliverables the deliverables to set
	 */
	public void setDeliverables(String deliverables) {
		this.deliverables = deliverables;
	}

	/**
	 * @return the targetAudience
	 */
	public String getTargetAudience() {
		return targetAudience;
	}

	/**
	 * @param targetAudience the targetAudience to set
	 */
	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}

	/**
	 * @return the costEstimate
	 */
	public String getCostEstimate() {
		return costEstimate;
	}

	/**
	 * @param costEstimate the costEstimate to set
	 */
	public void setCostEstimate(String costEstimate) {
		this.costEstimate = costEstimate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName
				+ ", projectOwner=" + projectOwner
				+ ", projectShortDescription=" + projectShortDescription
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
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((projectOwner == null) ? 0 : projectOwner.hashCode());
		result = prime * result + ((projectShortDescription == null) ? 0 : projectShortDescription.hashCode());
		result = prime * result + ((updatedLastDate == null) ? 0 : updatedLastDate.hashCode());
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
		if (!(obj instanceof Project)) {
			return false;
		}
		Project other = (Project) obj;
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
		if (projectName == null) {
			if (other.projectName != null) {
				return false;
			}
		} else if (!projectName.equals(other.projectName)) {
			return false;
		}
		if (projectOwner == null) {
			if (other.projectOwner != null) {
				return false;
			}
		} else if (!projectOwner.equals(other.projectOwner)) {
			return false;
		}
		if (projectShortDescription == null) {
			if (other.projectShortDescription != null) {
				return false;
			}
		} else if (!projectShortDescription
				.equals(other.projectShortDescription)) {
			return false;
		}
		if (updatedLastDate == null) {
			if (other.updatedLastDate != null) {
				return false;
			}
		} else if (!updatedLastDate.equals(other.updatedLastDate)) {
			return false;
		}
		return true;
	}
}
