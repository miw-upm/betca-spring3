package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalOneToOneEmbeddedEntity;

public interface UnidirectionalOneToOneEmbeddedDao extends JpaRepository<UnidirectionalOneToOneEmbeddedEntity, Integer>{

}
