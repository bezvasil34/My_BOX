package ua.com.mybox.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nameOfCategories;

	
	@ManyToMany
	@JoinTable(name="categories_producer",
	joinColumns = @JoinColumn(name="id_categories"),
	inverseJoinColumns = @JoinColumn(name = "id_producer"))
	private List<Producer> producers;
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(String nameOfCategories) {
		super();
		this.nameOfCategories = nameOfCategories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfCategories() {
		return nameOfCategories;
	}

	public void setNameOfCategories(String nameOfCategories) {
		this.nameOfCategories = nameOfCategories;
	}



	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	@Override
	public String toString() {
		return "Categories [nameOfCategories=" + nameOfCategories + "]";
	}
	
	

}
