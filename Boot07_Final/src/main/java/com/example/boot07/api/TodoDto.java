package com.example.boot07.api;

public class TodoDto {
	private int id;
	private String title;
	private boolean isComplete;
	
	public TodoDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", isComplete=" + isComplete + "]";
	}
}