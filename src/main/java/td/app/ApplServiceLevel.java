package td.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import td.entities.Author;
import td.service.AuthorService;

public class ApplServiceLevel {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		System.out.println(" . ApplicationContext created ");
		
		AuthorService authorService = ac.getBean(AuthorService.class);
		System.out.println("AuthorService ready.");

		//--------------------------------------------------------
		
		Author author = authorService.findById(1);
		System.out.println("Author #1 : " + author);
		
		author = authorService.findById(856);
		System.out.println("Author #856 : " + author);
		
		System.out.println("All authors : ");
		Iterable<Author> authors = authorService.findAll() ;
		for ( Author a : authors ) {
			System.out.println(" . " + a );
		}

		// to close the context (and to avoid the warning)
		((AbstractApplicationContext) ac).close(); 

	}

}
