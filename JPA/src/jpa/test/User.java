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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="User.getAll", query="SELECT u From User u"),
	@NamedQuery(name="User.getbyName", query="SELECT u From User u where u.name=:name")

})
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	private String name;
	private int age;
	private String email;
	
	@ManyToOne
	private Role role;
	
	@ManyToMany(mappedBy="users"/*, cascade = CascadeType.ALL*/)
	/*@JoinTable(name = "programs_users",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id") )*/
	private List<Program> programs;
	
	public List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	
	
	public String getMail() {
		return email;
	}
	public void setMail(String mail) {
		this.email = mail;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public User(String name, int age, String mail) {
		super();
		this.name = name;
		this.age = age;
		this.email = mail;
	}
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
