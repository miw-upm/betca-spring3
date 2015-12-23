package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalOneToOneEmbeddedEntity;

public interface UnidirectionalOneToOneEmbeddedDao extends JpaRepository<UnidirectionalOneToOneEmbeddedEntity, Integer>{

}
