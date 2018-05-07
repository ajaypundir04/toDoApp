package com.emirates.todo.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.todo.entity.Tasks;
import com.emirates.todo.repositories.TasksRepository;



@RestController
@RequestMapping("/tasks")
public class TasksRestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Tasks> tasks(){	
		return this.tasksRepository.findAllCustom();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Tasks getTaskById(@PathVariable("id") Long id){
	    return tasksRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveTask(@RequestBody @Valid Tasks task){
		task.setId(null);
		tasksRepository.save(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteTask(@PathVariable("id") Long id){
		tasksRepository.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void editTask(@RequestBody @Valid Tasks editedTask ,@PathVariable("id") Long id){
		editedTask.setId(id);
		tasksRepository.saveAndFlush(editedTask);
	}
	
	@Autowired TasksRepository tasksRepository;
}