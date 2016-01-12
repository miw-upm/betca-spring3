package spring.persistence.daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.library.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
}
