package spring.persistence.daos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.persistence.entities.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer> {

    UnRelatedEntity findByNickIgnoreCase(String nick);

    List<UnRelatedEntity> findFirst3ByNickStartingWith(String prefix);
    
    List<UnRelatedEntity> findByNickOrLargeOrderByIdDesc(String nick, String large);

    List<UnRelatedEntity> findByIdGreaterThan(int id, Pageable pageable);
    
    List<UnRelatedEntity> findByIdIn(Collection<Integer> values);
    
    //?1 ?2 ?3...
    //:name ... @Param("name")
    @Query("select u.nick from other_name_for_unrelatedentity u where u.nick like ?1")
    List<String> findNickByNickLike(String nick);
    
    @Query("select u.id from other_name_for_unrelatedentity u where u.id > ?1 and u.id < ?2")
    List<Integer> findIdByIdBetween(int initial, int end); 

}
