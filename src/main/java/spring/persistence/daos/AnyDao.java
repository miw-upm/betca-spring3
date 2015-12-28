package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.AnyEntity;

public interface AnyDao extends JpaRepository<AnyEntity, Integer> {
}
