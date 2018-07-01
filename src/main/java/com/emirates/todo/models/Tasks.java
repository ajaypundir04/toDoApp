package com.emirates.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tasks {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 2, max = 1000)
	private String taskname;

	@NotNull
	private Boolean isdone;

	public Tasks(String taskname, Boolean isdone) {
		this.taskname = taskname;
		this.isdone = false;
	}

	public Tasks() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Boolean getIsdone() {
		return isdone;
	}

	public void setIsdone(Boolean isdone) {
		this.isdone = isdone;
	}



}
