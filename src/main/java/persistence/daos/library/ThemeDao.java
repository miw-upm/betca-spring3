package persistence.daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.library.Theme;

public interface ThemeDao extends JpaRepository<Theme, Integer> {
}
