/**
 * RequestMapperController
 */
package com.myprojects.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.RequestContext;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Controller(IProject.REQUEST_MAPPER_CONTROLLER)
public class RequestMapperController {

	/**
	 * 
	 * @param requestContext
	 * @return
	 */
	public String getProjectId(RequestContext requestContext) { // ExternalContext context
        String projectId = requestContext.getRequestParameters().get(IProject.PROJECT_ID_LOWER);
        // String paramValue = context.getRequestParameterMap().get(name);
        return projectId;
    }
}
