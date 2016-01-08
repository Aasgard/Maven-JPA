package domain;

import javax.persistence.*;

@Entity
public class ElectronicDevice {

	private Long id;
	private String name;
	private double averageConsumption;
	private Home home;
	
	@Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public ElectronicDevice(String n, double c){
		this.setName(n);
		this.setAverageConsumption(c);
	}
	
	public String toString(){
		return "[@ElectronicDevice";
	}

	public double getAverageConsumption() {
		return averageConsumption;
	}

	public void setAverageConsumption(double averageConsumption) {
		this.averageConsumption = averageConsumption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
}
