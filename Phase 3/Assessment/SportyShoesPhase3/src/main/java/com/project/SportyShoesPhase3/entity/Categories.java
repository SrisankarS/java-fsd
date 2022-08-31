package com.project.SportyShoesPhase3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String categoryName;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoryName=" + categoryName + "]";
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
