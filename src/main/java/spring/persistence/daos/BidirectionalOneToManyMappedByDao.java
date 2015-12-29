package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalOneToManyMappedByEntity;

public interface BidirectionalOneToManyMappedByDao extends JpaRepository<BidirectionalOneToManyMappedByEntity, Integer>{

}
