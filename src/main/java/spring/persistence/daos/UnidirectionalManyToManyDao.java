package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalManyToManyEntity;

public interface UnidirectionalManyToManyDao extends JpaRepository<UnidirectionalManyToManyEntity, Integer> {
}
