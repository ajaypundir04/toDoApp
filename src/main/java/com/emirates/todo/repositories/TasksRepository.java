package com.emirates.todo.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emirates.todo.models.Tasks;



public interface TasksRepository extends JpaRepository<Tasks, Long> {

	Collection<Tasks> findBytaskname(String taskname);
	Collection<Tasks> findBytasknameStartsWithIgnoreCase(String taskname);
	
	@Query("select new map (T.id as id, T.taskname as taskname,  T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustom();
	
}
