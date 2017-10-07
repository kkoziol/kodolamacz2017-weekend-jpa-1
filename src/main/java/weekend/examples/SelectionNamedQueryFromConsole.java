package weekend.examples;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javassist.compiler.ast.Symbol;
import weekend.task4.User;

public class SelectionNamedQueryFromConsole {
	static PrintStream OUT = System.out;
	static InputStream IN = System.in;

	public static void main(String[] args) {
		int providedId;
		
		Scanner scanner = new Scanner(IN);
		OUT.println("Podaj id:");
		providedId = scanner.nextInt();
		scanner.close();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class);
		query.setParameter("ID", providedId);
		User result = query.getSingleResult();
		OUT.println(result);

		entityManager.close();
		entityManagerFactory.close();
	}
}
