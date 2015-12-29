package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalOneToOneJoinColumnEntity;

public interface BidirectionalOneToOneJoinColumnDao extends JpaRepository<BidirectionalOneToOneJoinColumnEntity, Integer>{

}
