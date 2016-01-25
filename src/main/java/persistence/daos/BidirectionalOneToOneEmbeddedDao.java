package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalOneToOneEmbeddedEntity;

public interface BidirectionalOneToOneEmbeddedDao extends JpaRepository<BidirectionalOneToOneEmbeddedEntity, Integer>{

}
