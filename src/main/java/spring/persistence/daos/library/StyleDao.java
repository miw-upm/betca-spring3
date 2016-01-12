package spring.persistence.daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.library.Style;

public interface StyleDao extends JpaRepository<Style, Integer> {
    Style findByNameIgnoreCase(String name);
}
