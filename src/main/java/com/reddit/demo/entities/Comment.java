package com.reddit.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private User user;
	private String text;
	private String title;
	private Time dateTime;
	private Comment comment[];
	
	
	public Comment(User user, String text, Time dateTime, Comment[] comment) {
		super();
		this.user = user;
		this.text = text;
		this.dateTime = dateTime;
		this.comment = comment;
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
	public Comment[] getComment() {
		return comment;
	}
	public void setComment(Comment[] comment) {
		this.comment = comment;
	}
	
	
}
