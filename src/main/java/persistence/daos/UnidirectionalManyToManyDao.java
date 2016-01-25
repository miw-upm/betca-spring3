package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.UnidirectionalManyToManyEntity;

public interface UnidirectionalManyToManyDao extends JpaRepository<UnidirectionalManyToManyEntity, Integer> {
}
