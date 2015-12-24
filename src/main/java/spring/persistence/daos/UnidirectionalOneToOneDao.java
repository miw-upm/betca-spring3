package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalOneToOneEntity;

public interface UnidirectionalOneToOneDao extends JpaRepository<UnidirectionalOneToOneEntity, Integer> {
}
