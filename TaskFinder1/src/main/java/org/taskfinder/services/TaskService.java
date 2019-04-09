package org.taskfinder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskfinder.entities.Offer;
import org.taskfinder.entities.Task;
import org.taskfinder.entities.User;
import org.taskfinder.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task>  findUserTask(User user){
		
		return taskRepository.findByUser(user);
	}
	
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	public List<Task> findByDescription(String description) {
		// TODO Auto-generated method stub
		return  taskRepository.findByDescriptionLike("%"+description+"%");
	}

	public Task findById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}
	
/*	public Task findByEmail(String email) {
		// TODO Auto-generated method stub
		return taskRepository.findByEmail(email);
	}*/
	
	public List<Task> findByCompleted() {
		
		return taskRepository.findByCompleted(1);
	}
	
	
	public void save(Task task) {
		
		taskRepository.save(task);
	}


}
