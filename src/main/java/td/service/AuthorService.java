package td.service;

import td.entities.Author;

public interface AuthorService {

	Author findById( Integer id ) ;
	
	Iterable<Author> findAll() ;

}
