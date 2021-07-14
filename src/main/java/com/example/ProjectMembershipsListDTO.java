package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectMembershipsListDTO {

	private List<ProjectMembershipsDTO> projectMembershipsList;

	public List<ProjectMembershipsDTO> getProjectMembershipsList() {
		return projectMembershipsList;
	}

	public void setProjectMembershipsList(List<ProjectMembershipsDTO> projectMembershipsList) {
		this.projectMembershipsList = projectMembershipsList;
	}
	
}
