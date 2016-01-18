package td.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import td.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

	List<Author> findByLastName(String lastName);

	List<Author> findByFirstName(String firstName);
	
}
