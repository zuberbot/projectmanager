/**
 * ProjectDetails
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
@Table(name=IProject.PROJECT_DETAILS_TABLE)
public class ProjectDetails implements Serializable {

	private static final long serialVersionUID = -3152055710918711967L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="project_id")
	private int projectId;
	
	@Column(name="funding_sources")
	private String fundingSources;
	
	@Column(name="scope")
	private String scope;
	
	@Column(name="milestones")
	private String milestones;
	
	@Column(name="dependencies")
	private String dependencies;
	
	@Column(name="risks")
	private String risks;
	
	@Column(name="assumptions")
	private String assumptions;
	
	@Column(name="constraints")
	private String constraints;
	
	@Column(name="document_links")
	private String documentLinks;

	@Column(name="other_links")
	private String otherLinks;
	
	@Column(name="social_media")
	private String socialMedia;
	
	@Column(name="locations")
	private String locations;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_last_date")
	private String updatedLastDate;
	
	@Column(name="active")
	private String active;

	/**
	 * 
	 */
	public ProjectDetails() {
		this.projectId = 0;
		this.fundingSources = null;
		this.scope = null;
		this.milestones = null;
		this.dependencies = null;
		this.risks = null;
		this.assumptions = null;
		this.constraints = null;
		this.documentLinks = null;
		this.otherLinks = null;
		this.socialMedia = null;
		this.locations = null;
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
	 * @return the fundingSources
	 */
	public String getFundingSources() {
		return fundingSources;
	}

	/**
	 * @param fundingSources the fundingSources to set
	 */
	public void setFundingSources(String fundingSources) {
		this.fundingSources = fundingSources;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the milestones
	 */
	public String getMilestones() {
		return milestones;
	}

	/**
	 * @param milestones the milestones to set
	 */
	public void setMilestones(String milestones) {
		this.milestones = milestones;
	}

	/**
	 * @return the dependencies
	 */
	public String getDependencies() {
		return dependencies;
	}

	/**
	 * @param dependencies the dependencies to set
	 */
	public void setDependencies(String dependencies) {
		this.dependencies = dependencies;
	}

	/**
	 * @return the risks
	 */
	public String getRisks() {
		return risks;
	}

	/**
	 * @param risks the risks to set
	 */
	public void setRisks(String risks) {
		this.risks = risks;
	}

	/**
	 * @return the assumptions
	 */
	public String getAssumptions() {
		return assumptions;
	}

	/**
	 * @param assumptions the assumptions to set
	 */
	public void setAssumptions(String assumptions) {
		this.assumptions = assumptions;
	}

	/**
	 * @return the constraints
	 */
	public String getConstraints() {
		return constraints;
	}

	/**
	 * @param constraints the constraints to set
	 */
	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}

	/**
	 * @return the documentLinks
	 */
	public String getDocumentLinks() {
		return documentLinks;
	}

	/**
	 * @param documentLinks the documentLinks to set
	 */
	public void setDocumentLinks(String documentLinks) {
		this.documentLinks = documentLinks;
	}

	/**
	 * @return the otherLinks
	 */
	public String getOtherLinks() {
		return otherLinks;
	}

	/**
	 * @param otherLinks the otherLinks to set
	 */
	public void setOtherLinks(String otherLinks) {
		this.otherLinks = otherLinks;
	}

	/**
	 * @return the socialMedia
	 */
	public String getSocialMedia() {
		return socialMedia;
	}

	/**
	 * @param socialMedia the socialMedia to set
	 */
	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	/**
	 * @return the locations
	 */
	public String getLocations() {
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(String locations) {
		this.locations = locations;
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
		return "ProjectDetails [id=" + id + ", projectId=" + projectId
				+ ", fundingSources=" + fundingSources + ", scope=" + scope
				+ ", milestones=" + milestones + ", dependencies="
				+ dependencies + ", risks=" + risks + ", assumptions="
				+ assumptions + ", constraints=" + constraints
				+ ", documentLinks=" + documentLinks + ", otherLinks="
				+ otherLinks + ", socialMedia=" + socialMedia + ", locations="
				+ locations + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assumptions == null) ? 0 : assumptions.hashCode());
		result = prime * result
				+ ((constraints == null) ? 0 : constraints.hashCode());
		result = prime * result
				+ ((dependencies == null) ? 0 : dependencies.hashCode());
		result = prime * result
				+ ((documentLinks == null) ? 0 : documentLinks.hashCode());
		result = prime * result
				+ ((fundingSources == null) ? 0 : fundingSources.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((locations == null) ? 0 : locations.hashCode());
		result = prime * result
				+ ((milestones == null) ? 0 : milestones.hashCode());
		result = prime * result
				+ ((otherLinks == null) ? 0 : otherLinks.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((risks == null) ? 0 : risks.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result
				+ ((socialMedia == null) ? 0 : socialMedia.hashCode());
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
		if (!(obj instanceof ProjectDetails)) {
			return false;
		}
		ProjectDetails other = (ProjectDetails) obj;
		if (assumptions == null) {
			if (other.assumptions != null) {
				return false;
			}
		} else if (!assumptions.equals(other.assumptions)) {
			return false;
		}
		if (constraints == null) {
			if (other.constraints != null) {
				return false;
			}
		} else if (!constraints.equals(other.constraints)) {
			return false;
		}
		if (dependencies == null) {
			if (other.dependencies != null) {
				return false;
			}
		} else if (!dependencies.equals(other.dependencies)) {
			return false;
		}
		if (documentLinks == null) {
			if (other.documentLinks != null) {
				return false;
			}
		} else if (!documentLinks.equals(other.documentLinks)) {
			return false;
		}
		if (fundingSources == null) {
			if (other.fundingSources != null) {
				return false;
			}
		} else if (!fundingSources.equals(other.fundingSources)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (locations == null) {
			if (other.locations != null) {
				return false;
			}
		} else if (!locations.equals(other.locations)) {
			return false;
		}
		if (milestones == null) {
			if (other.milestones != null) {
				return false;
			}
		} else if (!milestones.equals(other.milestones)) {
			return false;
		}
		if (otherLinks == null) {
			if (other.otherLinks != null) {
				return false;
			}
		} else if (!otherLinks.equals(other.otherLinks)) {
			return false;
		}
		if (projectId != other.projectId) {
			return false;
		}
		if (risks == null) {
			if (other.risks != null) {
				return false;
			}
		} else if (!risks.equals(other.risks)) {
			return false;
		}
		if (scope == null) {
			if (other.scope != null) {
				return false;
			}
		} else if (!scope.equals(other.scope)) {
			return false;
		}
		if (socialMedia == null) {
			if (other.socialMedia != null) {
				return false;
			}
		} else if (!socialMedia.equals(other.socialMedia)) {
			return false;
		}
		return true;
	}

}
