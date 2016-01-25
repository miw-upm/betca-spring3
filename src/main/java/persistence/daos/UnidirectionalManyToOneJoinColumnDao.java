package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalManyToOneJoinColumnEntity;

public interface UnidirectionalManyToOneJoinColumnDao extends JpaRepository<UnidirectionalManyToOneJoinColumnEntity, Integer> {
}
