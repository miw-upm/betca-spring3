package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.AnyEntity;

public interface AnyDao extends JpaRepository<AnyEntity, Integer> {
}
