package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalOneToOneEmbeddedEntity;

public interface BidirectionalOneToOneEmbeddedDao extends JpaRepository<BidirectionalOneToOneEmbeddedEntity, Integer>{

}
