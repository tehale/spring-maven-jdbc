package controller;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.jdbc.dao.*;
import com.jdbc.domainmodel.*;
public class Main {
private Main(){};

public static void main(String[] args) {
	DerbyDao dao = new DerbyDao();
	// Initialize the datasource, could /should be done of Spring
	// configuration
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	//dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
	//dataSource.setUrl("jdbc:derby:localhost:3306/tenant_18;create=true");
	dataSource.setUrl("jdbc:mysql://localhost:3306/test");
	dataSource.setUsername("root");
	dataSource.setPassword("openit");
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	

	// Inject the datasource into the dao
	dao.setDataSource(dataSource);

	dao.create("Lars", "Vogel");
	dao.create("Jim", "Knopf");
	dao.create("Lars", "Man");
	dao.create("Spider", "Man");
	System.out.println("Now select and list all persons");
	List<Person> list = dao.selectAll();
	for (Person myPerson : list) {
		System.out.print(myPerson.getFirstName() + " ");
		System.out.println(myPerson.getLastName());
	}
	System.out
			.println("Now select and list all persons with have the firstname Lars and lastname Vogel");
	list = dao.select("Lars", "Vogel");
	for (Person myPerson : list) {
		System.out.print(myPerson.getFirstName() + " ");
		System.out.println(myPerson.getLastName());
	}

	// Clean-up
	dao.deleteAll();
}

}
