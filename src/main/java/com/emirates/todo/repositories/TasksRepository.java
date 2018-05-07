package com.emirates.todo.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emirates.todo.entity.Tasks;


@Repository("tasksRepository")
public interface TasksRepository extends JpaRepository<Tasks, Long> {

	Collection<Tasks> findBytaskname(String taskname);
	Collection<Tasks> findBytasknameStartsWithIgnoreCase(String taskname);
	
	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustom();
	
}
