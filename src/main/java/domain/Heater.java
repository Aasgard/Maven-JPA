package domain;

import javax.persistence.*;

@Entity
public class Heater {

	private Long id;
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
    
	public Heater(double ac, Home h){
		this.averageConsumption = ac;
		this.home = h;
	}

	public double getAverageConsumption() {
		return averageConsumption;
	}

	public void setAverageConsumption(double averageConsumption) {
		this.averageConsumption = averageConsumption;
	}

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
}
