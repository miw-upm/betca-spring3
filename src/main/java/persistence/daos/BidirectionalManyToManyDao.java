package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalManyToManyEntity;

public interface BidirectionalManyToManyDao extends JpaRepository<BidirectionalManyToManyEntity, Integer>{

}
