package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalManyToOneEntity;

public interface UnidirectionalManyToOneDao extends JpaRepository<UnidirectionalManyToOneEntity, Integer> {
}
