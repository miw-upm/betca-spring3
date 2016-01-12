package spring.persistence.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.persistence.entities.UnRelatedEntity;

@Repository
public class UnRelatedDaoImpl implements UnRelatedExtended {
    
    @Autowired
    private UnRelatedDao unRelatedDao;

    @Override
    public void custom(UnRelatedEntity entity) {
        unRelatedDao.save(entity);
    }

}
