package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalOneToManyEntity;

public interface UnidirectionalOneToManyDao extends JpaRepository<UnidirectionalOneToManyEntity, Integer> {
}
