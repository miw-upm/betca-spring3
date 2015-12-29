package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.UnidirectionalManyToOneJoinColumnEntity;

public interface UnidirectionalManyToOneJoinColumnDao extends JpaRepository<UnidirectionalManyToOneJoinColumnEntity, Integer> {
}
