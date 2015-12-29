package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalOneToOneJoinColumnEntity;

public interface UnidirectionalOneToOneJoinColumnDao extends JpaRepository<UnidirectionalOneToOneJoinColumnEntity, Integer> {
}
