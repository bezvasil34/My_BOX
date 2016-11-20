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
public class Producer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String  nameOfProducer;
	
	
	@ManyToMany
	@JoinTable(name="categories_producer",
	joinColumns = @JoinColumn(name="id_producer"),
	inverseJoinColumns = @JoinColumn(name = "id_categories"))
	private List<Categories> categories;
	
	@ManyToMany
	@JoinTable(name="commodity_producer",
	joinColumns = @JoinColumn(name="id_commodity"),
	inverseJoinColumns = @JoinColumn(name = "id_producer"))
	private List<Commodity> commodities;
	
	
	public Producer() {
		// TODO Auto-generated constructor stub
	}


	public Producer(String nameOfProducer) {
		super();
		this.nameOfProducer = nameOfProducer;
			}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameOfProducer() {
		return nameOfProducer;
	}


	public void setNameOfProducer(String nameOfProducer) {
		this.nameOfProducer = nameOfProducer;
	}





	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public List<Commodity> getCommodities() {
		return commodities;
	}


	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}


	@Override
	public String toString() {
		return "Producer [nameOfProducer=" + nameOfProducer +  "]";
	}
	
	
	
}
