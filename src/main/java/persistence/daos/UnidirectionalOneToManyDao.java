package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalOneToManyEntity;

public interface UnidirectionalOneToManyDao extends JpaRepository<UnidirectionalOneToManyEntity, Integer> {
}
