package spring.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.persistence.entities.OneToManyMappedByEntity;

public interface OneToManyMappedByDao extends JpaRepository<OneToManyMappedByEntity, Integer>{

}
