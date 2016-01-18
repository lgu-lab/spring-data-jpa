package td.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import td.entities.Author;
import td.repository.AuthorRepository;

public class AppRepositoryLevel {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		System.out.println(" . ApplicationContext created ");
		
		AuthorRepository authorRepository = ac.getBean(AuthorRepository.class);
		System.out.println("AuthorRepository ready. Real class is " + authorRepository.getClass() ); // com.sun.proxy.$Proxy20
		
		//---------------------------------------------------------
		
		Author author = authorRepository.findOne(1);
		System.out.println("Find Author #1 : " + author);
		
		System.out.println("Exists Author #1 ? : " + authorRepository.exists(1));
		
		author = authorRepository.findOne(856);
		System.out.println("Find Author #856 : " + author);
		
		System.out.println("All authors : ");
		Iterable<Author> authors = authorRepository.findAll() ;
		for ( Author a : authors ) {
			System.out.println(" . " + a );
		}

		System.out.println("Find authors by last name 'FLEURY' : ");
		for ( Author a : authorRepository.findByLastName("FLEURY") ) {
			System.out.println(" . " + a );
		}

		System.out.println("Find authors by first name 'Emile' : ");
		for ( Author a : authorRepository.findByFirstName("Emile") ) {
			System.out.println(" . " + a );
		}

		
		// to close the context (and to avoid the warning)
		((AbstractApplicationContext) ac).close(); 

	}

}
