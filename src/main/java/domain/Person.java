package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Person {
	
    private Long id;
    private String name;
    private String mail;
    
    /* Person's friend-list */
	private List<Person> friendList;
	
	/* Person's homes */
	private List<Home> homesList;

	public Person(){
	}
	
    public Person(String name, String m) {
        this.name = name;
        this.mail = m;
        this.friendList = new ArrayList<Person>();
        this.homesList = new ArrayList<Home>();
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns={@JoinColumn(name="personId")},
    inverseJoinColumns={@JoinColumn(name="friendId")}
    
    		)
    public List<Person> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Person> friendList) {
		this.friendList = friendList;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public List<Home> getHomesList() {
		return homesList;
	}
	
	public void setHomesList(List<Home> homesList) {
		this.homesList = homesList;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
    public String toString() {
        return "@Person [ " + this.name + " , " + this.homesList.toString() + " ]";
    }

}
