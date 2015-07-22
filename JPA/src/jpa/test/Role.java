package jpa.test;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@NamedQuery(name="Role.getName", query="select r from Role r where r.name=:name" )
@Table(name="roles")
public class Role {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    
    /*@ManyToMany(mappedBy = "roles")
    private Collection<User> users;*/
    
    @OneToMany(mappedBy="role")
//    @JoinTable
    private Collection<User> users;
    
	private String name;
	
	
	public Role(String name) {
		
		this.name = name;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
