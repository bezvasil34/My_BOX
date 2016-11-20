package ua.com.mybox.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


@Entity
public class Commodity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nameOfCommodity;
	private String price;
	
	@Lob
	private String description;


	private String pathImage;
	
	@ManyToMany
	@JoinTable(name="commodity_producer",
	joinColumns = @JoinColumn(name="id_producer"),
	inverseJoinColumns = @JoinColumn(name = "id_commodity"))
	private List<Producer> producers;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_commodity",
            joinColumns = @JoinColumn(name = "id_commodity"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User>users;
	
	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}


	public Commodity(String nameOfCommodity, String price, String description) {
		super();
		this.nameOfCommodity = nameOfCommodity;
		this.price = price;
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getOriginNameOfCommodity() {
		return nameOfCommodity;
	}

	public String getNameOfCommodity() {
		return nameOfCommodity;
	}

	public void setNameOfCommodity(String nameOfCommodity) {
		this.nameOfCommodity = nameOfCommodity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
	
	

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "Товар:" + nameOfCommodity + ", Ціна:" + price+ "]";
	}
	
	
}
