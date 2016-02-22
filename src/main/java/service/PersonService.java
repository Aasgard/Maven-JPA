package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Person;

public class PersonService {

	private EntityManager manager = EntityManagerHelper.getEntityManager();
	private EntityTransaction tx = manager.getTransaction();
	
	public PersonService(){
	}
	
	public List<Person> getPersons(){
		String q = "SELECT p FROM Person p";
		Query query = manager.createQuery(q);
		
		return query.getResultList();
	}
	
	public void addPerson(Person p){
		tx.begin();
		manager.persist(p);
		tx.commit();
	}
	
}
