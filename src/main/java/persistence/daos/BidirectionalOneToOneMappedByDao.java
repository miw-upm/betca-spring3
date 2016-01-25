package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalOneToOneMappedByEntity;

public interface BidirectionalOneToOneMappedByDao extends JpaRepository<BidirectionalOneToOneMappedByEntity, Integer>{

}
