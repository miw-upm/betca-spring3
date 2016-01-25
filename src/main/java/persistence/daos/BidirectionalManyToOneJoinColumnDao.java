package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalManyToOneJoinColumnEntity;

public interface BidirectionalManyToOneJoinColumnDao extends JpaRepository<BidirectionalManyToOneJoinColumnEntity, Integer>{

}
