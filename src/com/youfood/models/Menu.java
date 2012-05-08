package com.youfood.models;

public class Menu {

	private int id;
	private String name;
	private String description;

	
	// GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
}
