package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalOneToOneMappedByEntity;

public interface BidirectionalOneToOneMappedByDao extends JpaRepository<BidirectionalOneToOneMappedByEntity, Integer>{

}
