package td.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import td.entities.Author;
import td.repository.AuthorRepository;
import td.service.AuthorService;

@Component
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public Author findById( Integer id ) {
		return authorRepository.findOne(id);
	}

	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

	public void delete(Author author) {
		authorRepository.delete(author);
	}
	public void delete(int id) {
		authorRepository.delete(id);
	}

	
	
	public void xxx(int id, Author entity) {
		
		// Basic operation provided by the standard "Repository"
		long count = authorRepository.count();
		
		//--- DELETE
		authorRepository.delete(entity);
		authorRepository.delete(id);
		authorRepository.deleteAll();
		authorRepository.delete(new LinkedList<Author>() );
		
		authorRepository.exists(id);
		
		//--- FIND
		Iterable<Author> list = authorRepository.findAll();
		authorRepository.findOne(id);		
		authorRepository.findAll(new LinkedList<Integer>());
		
		//--- SAVE
		authorRepository.save(entity);
		authorRepository.save(new LinkedList<Author>() );
		
		
	}
}
