package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.BidirectionalOneToOneJoinColumnEntity;

public interface BidirectionalOneToOneJoinColumnDao extends JpaRepository<BidirectionalOneToOneJoinColumnEntity, Integer>{

}
