package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import domain.*;

public class PersonService {

	private EntityManager manager;
	
	public PersonService(EntityManager em){
		this.manager = em;
	}
	
	public List<Person> getPersons(){
		String q = "SELECT p FROM Person p";
		Query query = manager.createQuery(q);
		
		return query.getResultList();
	}
	
}
