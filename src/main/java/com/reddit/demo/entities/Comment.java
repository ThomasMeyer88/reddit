package com.reddit.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.sql.Time;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private User user;
	
	private String text;
	private String title;
	private Time dateTime;
	
    @OneToMany
	private List<Comment> comments;
	
	
    
	
	public Comment(User user, String text, Time dateTime, List<Comment> comments) {
		super();
		this.user = user;
		this.text = text;
		this.dateTime = dateTime;
		this.comments = comments;
	}
	public Comment(User user, String text, String title, Time dateTime) {
		super();
		this.user = user;
		this.text = text;
		this.title = title;
		this.dateTime = dateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Time getDateTime() {
		return dateTime;
	}
	public void setDateTime(Time dateTime) {
		this.dateTime = dateTime;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
