package com.modules.manage_module.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="modules")
public class Modules {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String moduleid;
	private String projectid;
	private String name;
	private String description;
	private String owner;
	private String status;
	private LocalDateTime startdate;
	private LocalDateTime duedate;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public Modules() {
		super();
	}

	public Modules(String moduleid, String projectid, String name, String description, String owner, String status,
			LocalDateTime startdate, LocalDateTime duedate, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.moduleid = moduleid;
		this.projectid = projectid;
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.status = status;
		this.startdate = startdate;
		this.duedate = duedate;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public LocalDateTime getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDateTime duedate) {
		this.duedate = duedate;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}
