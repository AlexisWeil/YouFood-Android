package com.youfood.models;

public class Product {

	private int id;
	private String name;
	private String abbreviation;
	private String description;
	private String photoUrl;
	private float price;
	private Category category;
	private boolean permanent;

	
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", abbreviation="
				+ abbreviation + ", description=" + description + ", photoUrl="
				+ photoUrl + ", price=" + price + ", category=" + category
				+ ", permanent=" + permanent + "]";
	}
}
