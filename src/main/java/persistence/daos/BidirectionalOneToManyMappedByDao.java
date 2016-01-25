package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalOneToManyMappedByEntity;

public interface BidirectionalOneToManyMappedByDao extends JpaRepository<BidirectionalOneToManyMappedByEntity, Integer>{

}
