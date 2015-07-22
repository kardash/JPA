package jpa.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="Program.getName", query="select p from Program p where p.name=:name" )
@Table(name="programs")
public class Program {
	
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     
	 private int id;
	 private String name;
	 private Double price;
	 
	 @ManyToMany(cascade=CascadeType.ALL)
//	 @JoinTable(name = "programs_users",
//     joinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id"),
//     inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	 private List<User> users;
	 
	 
	 public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Program() {
	
	}
	public Program(String name, Double price) {

		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
}
