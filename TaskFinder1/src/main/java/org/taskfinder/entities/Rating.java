package org.taskfinder.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Rating {
@Id
@GeneratedValue
private Long id;

private String comment;
private int stars;


@ManyToOne
@JoinColumn(name="WORKER_EMAIL")
private User worker;

@ManyToOne
@JoinColumn(name="USER_EMAIL")
private User user;

@OneToOne
@JoinColumn(name="TASK_ID")
private Task task;



public Rating(String comment, int stars) {
	this.comment = comment;
	this.stars = stars;
	
}

public Rating(String comment, int stars, User user, User worker) {
	this.comment = comment;
	this.stars = stars;
	this.user = user;
	this.worker = worker;
}


public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Task getTask() {
	return task;
}

public void setTask(Task task) {
	this.task = task;
}

public User getWorker() {
	return worker;
}

public void setWorker(User worker) {
	this.worker = worker;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public int getStars() {
	return stars;
}

public void setStars(int stars) {
	this.stars = stars;
}



}
