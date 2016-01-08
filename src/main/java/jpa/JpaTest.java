package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Home;
import domain.Person;

public class JpaTest {

	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev"); /* Replace "dev" by "mysql" */
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		JpaTest test = new JpaTest(manager);
		tx.begin();
		try {
			/*Person p = new Person();
			p.setName("martin");
			manager.persist(p);*/
			test.createPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		test.listEmployees();
		
		manager.close();
		factory.close();
	}
	
	private void createPersons() {
	
		List<Home> homesList = new ArrayList<Home>();
		
		
		Person p3 = new Person("RICLET Robin", "robin.riclet@gmail.com");
		
		
		Home h = new Home(54,p3);
		Home h2 = new Home(74,p3);
		
		homesList.add(h);
		homesList.add(h2);
		
		p3.setHomesList(homesList);
		
		manager.persist(h);
		manager.persist(h2);
		
		manager.persist(new Person("LE PEVEDIC William","william.lepevedic@gmail.com"));
		manager.persist(new Person("LANCIEN François-Régis","francois.regis.lancien@gmail.com"));
		manager.persist(p3);
    }
	
	private void listEmployees() {
        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Person next : resultList) {
            System.out.println(next);
        }
    }

}
