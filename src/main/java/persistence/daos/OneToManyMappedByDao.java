package persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.entities.OneToManyMappedByEntity;

public interface OneToManyMappedByDao extends JpaRepository<OneToManyMappedByEntity, Integer>{

}
