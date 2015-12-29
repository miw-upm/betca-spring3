package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalManyToManyEntity;

public interface BidirectionalManyToManyDao extends JpaRepository<BidirectionalManyToManyEntity, Integer>{

}
