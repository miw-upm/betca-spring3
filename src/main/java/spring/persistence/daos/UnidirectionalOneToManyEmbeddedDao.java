package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalOneToManyEmbeddedEntity;

public interface UnidirectionalOneToManyEmbeddedDao extends JpaRepository<UnidirectionalOneToManyEmbeddedEntity, Integer>{

}
