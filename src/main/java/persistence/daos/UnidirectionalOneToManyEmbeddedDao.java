package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalOneToManyEmbeddedEntity;

public interface UnidirectionalOneToManyEmbeddedDao extends JpaRepository<UnidirectionalOneToManyEmbeddedEntity, Integer>{

}
