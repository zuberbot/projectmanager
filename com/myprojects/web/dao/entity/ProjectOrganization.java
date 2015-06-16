/**
 * ProjectOrganization
 */
package com.myprojects.web.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Entity
@Table(name=IProject.PROJECT_ORGANIZATION_TABLE)
public class ProjectOrganization implements Serializable {

	private static final long serialVersionUID = -3253984083465988692L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="project_id")
	private int projectId;
	
	@Column(name="governance")
	private String governance;
	
	@Column(name="team_structure")
	private String teamStructure;
	
	@Column(name="roles_responsibilities")
	private String rolesResponsibilities;
	
	@Column(name="facilities")
	private String facilities;
	
	@Column(name="resources")
	private String resources;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_last_date")
	private String updatedLastDate;
	
	@Column(name="active")
	private String active;

	/**
	 * 
	 */
	public ProjectOrganization() {
		this.projectId = 0;
		this.governance = null;
		this.teamStructure = null;
		this.rolesResponsibilities = null;
		this.facilities = null;
		this.resources = null;
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
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the governance
	 */
	public String getGovernance() {
		return governance;
	}

	/**
	 * @param governance the governance to set
	 */
	public void setGovernance(String governance) {
		this.governance = governance;
	}

	/**
	 * @return the teamStructure
	 */
	public String getTeamStructure() {
		return teamStructure;
	}

	/**
	 * @param teamStructure the teamStructure to set
	 */
	public void setTeamStructure(String teamStructure) {
		this.teamStructure = teamStructure;
	}

	/**
	 * @return the rolesResponsibilities
	 */
	public String getRolesResponsibilities() {
		return rolesResponsibilities;
	}

	/**
	 * @param rolesResponsibilities the rolesResponsibilities to set
	 */
	public void setRolesResponsibilities(String rolesResponsibilities) {
		this.rolesResponsibilities = rolesResponsibilities;
	}

	/**
	 * @return the facilities
	 */
	public String getFacilities() {
		return facilities;
	}

	/**
	 * @param facilities the facilities to set
	 */
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	/**
	 * @return the resources
	 */
	public String getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(String resources) {
		this.resources = resources;
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
		return "ProjectOrganization [id=" + id + ", projectId=" + projectId
				+ ", governance=" + governance + ", teamStructure="
				+ teamStructure + ", rolesResponsibilities="
				+ rolesResponsibilities + ", facilities=" + facilities
				+ ", resources=" + resources + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((facilities == null) ? 0 : facilities.hashCode());
		result = prime * result
				+ ((governance == null) ? 0 : governance.hashCode());
		result = prime * result + id;
		result = prime * result + projectId;
		result = prime * result
				+ ((resources == null) ? 0 : resources.hashCode());
		result = prime
				* result
				+ ((rolesResponsibilities == null) ? 0 : rolesResponsibilities
						.hashCode());
		result = prime * result
				+ ((teamStructure == null) ? 0 : teamStructure.hashCode());
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
		if (!(obj instanceof ProjectOrganization)) {
			return false;
		}
		ProjectOrganization other = (ProjectOrganization) obj;
		if (facilities == null) {
			if (other.facilities != null) {
				return false;
			}
		} else if (!facilities.equals(other.facilities)) {
			return false;
		}
		if (governance == null) {
			if (other.governance != null) {
				return false;
			}
		} else if (!governance.equals(other.governance)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (projectId != other.projectId) {
			return false;
		}
		if (resources == null) {
			if (other.resources != null) {
				return false;
			}
		} else if (!resources.equals(other.resources)) {
			return false;
		}
		if (rolesResponsibilities == null) {
			if (other.rolesResponsibilities != null) {
				return false;
			}
		} else if (!rolesResponsibilities.equals(other.rolesResponsibilities)) {
			return false;
		}
		if (teamStructure == null) {
			if (other.teamStructure != null) {
				return false;
			}
		} else if (!teamStructure.equals(other.teamStructure)) {
			return false;
		}
		return true;
	}
}
