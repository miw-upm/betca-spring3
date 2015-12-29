package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.BidirectionalManyToOneJoinColumnEntity;

public interface BidirectionalManyToOneJoinColumnDao extends JpaRepository<BidirectionalManyToOneJoinColumnEntity, Integer>{

}
