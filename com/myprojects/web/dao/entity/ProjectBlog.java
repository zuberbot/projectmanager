/**
 * ProjectBlog
 */
package com.myprojects.web.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.myprojects.web.utility.IProject;
import com.myprojects.web.utility.MyProjectsUtility;

/**
 * @author Chuck
 *
 */
@Entity
@Table(name=IProject.PROJECT_BLOG_TABLE)
public class ProjectBlog implements Serializable {

	private static final long serialVersionUID = 8493728690957746470L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="project_id")
	private int projectId;
	
	@Size(min=2, max=90, message="{Project.blog.title.error}")
	@Column(name="blog_title")
	private String blogTitle;
	
	@Size(min=5, message="{Project.blog.entry.error}")
	@Column(name="blog_entry")
	private String blogEntry;
	
	@Column(name="active")
	private String active;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_last_date")
	private String updatedLastDate;	
	
	/**
	 * 
	 */
	public ProjectBlog() {
		// Can initialize field values here
		this.blogTitle = "";
		this.blogEntry = "";
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
	 * @return the blogTitle
	 */
	public String getBlogTitle() {
		return blogTitle;
	}

	/**
	 * @param blogTitle the blogTitle to set
	 */
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	/**
	 * @return the blogEntry
	 */
	public String getBlogEntry() {		
		return blogEntry;
	}

	/**
	 * @param blogEntry the blogEntry to set
	 */
	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
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
	 * 
	 * @param context
	 */
	public void validateShowProjectBlog(ValidationContext context) {
		// http://docs.spring.io/spring-webflow/docs/current/reference/html/views.html#view-validation-jsr303-partial
        MessageContext messages = context.getMessageContext();
        String blogTitleErrorMessage = "Blog title must be filled in.";
        String blogEntryErrorMessage = "Blog entry must be filled in.";
        String bTitle = "blogTitle";
        String bEntry = "blogEntry";
        
        if (blogTitle == null || blogTitle.length() == 0) {
        	MessageBuilder mb = new MessageBuilder().error().source(bTitle).defaultText(blogTitleErrorMessage);
            messages.addMessage(mb.build());
        }
	
        if (blogEntry == null || blogEntry.length() == 0) {
        	MessageBuilder mb = new MessageBuilder().error().source(bEntry).defaultText(blogEntryErrorMessage);
            messages.addMessage(mb.build());
        }
        
        // Store the project id in session here
		RequestContext requestContext = RequestContextHolder.getRequestContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) requestContext.getExternalContext().getNativeRequest();
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("blog_project_id", projectId);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectBlog [id=" + id + ", projectId=" + projectId
				+ ", blogTitle=" + blogTitle + ", blogEntry=" + blogEntry
				+ ", active=" + active + ", createdDate=" + createdDate
				+ ", updatedLastDate=" + updatedLastDate + "]";
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
				+ ((blogEntry == null) ? 0 : blogEntry.hashCode());
		result = prime * result
				+ ((blogTitle == null) ? 0 : blogTitle.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + id;
		result = prime * result + projectId;
		result = prime * result
				+ ((updatedLastDate == null) ? 0 : updatedLastDate.hashCode());
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
		if (!(obj instanceof ProjectBlog)) {
			return false;
		}
		ProjectBlog other = (ProjectBlog) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (blogEntry == null) {
			if (other.blogEntry != null) {
				return false;
			}
		} else if (!blogEntry.equals(other.blogEntry)) {
			return false;
		}
		if (blogTitle == null) {
			if (other.blogTitle != null) {
				return false;
			}
		} else if (!blogTitle.equals(other.blogTitle)) {
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
		if (projectId != other.projectId) {
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
