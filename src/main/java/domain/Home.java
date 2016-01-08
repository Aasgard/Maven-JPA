package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Home {

	private Long id;
	private int squareMeters;
	private List<ElectronicDevice> edList;
	private List<Heater> heaterList;
	private Person person;
	
	public Home(){
		
	}
	
	public Home(int sm, Person person){
		this.squareMeters = sm;
		this.person= person;
	}
	
	@Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}

	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
	public List<ElectronicDevice> getEdList() {
		return edList;
	}

	public void setEdList(List<ElectronicDevice> edList) {
		this.edList = edList;
	}

	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
	public List<Heater> getHeaterList() {
		return heaterList;
	}

	public void setHeaterList(List<Heater> heaterList) {
		this.heaterList = heaterList;
	}

	public String toString(){
    	return "[@Home : ID : " + this.id + " squareMeters : " + this.squareMeters + "]";
    }

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
