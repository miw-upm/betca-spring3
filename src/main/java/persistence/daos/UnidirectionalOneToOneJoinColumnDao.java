package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalOneToOneJoinColumnEntity;

public interface UnidirectionalOneToOneJoinColumnDao extends JpaRepository<UnidirectionalOneToOneJoinColumnEntity, Integer> {
}
