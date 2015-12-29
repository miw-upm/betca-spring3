package spring.persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.BidirectionalManyToOneJoinColumnDao;
import spring.persistence.daos.OneToManyMappedByDao;
import spring.persistence.entities.BidirectionalManyToOneJoinColumnEntity;
import spring.persistence.entities.OneToManyMappedByEntity;

@Controller
public class BidirectionalManyToOneJoinColumnController {

    @Autowired
    private BidirectionalManyToOneJoinColumnDao bidirectionalManyToOneJoinColumnDao;

    @Autowired
    private OneToManyMappedByDao oneToManyMappedByDao;

    public void process() {
        OneToManyMappedByEntity[] array = {new OneToManyMappedByEntity("uno"), new OneToManyMappedByEntity("dos"),
                new OneToManyMappedByEntity("tres")};
        oneToManyMappedByDao.save(Arrays.asList(array));

        BidirectionalManyToOneJoinColumnEntity entity = new BidirectionalManyToOneJoinColumnEntity("Mi Nick", array[0]);
        BidirectionalManyToOneJoinColumnEntity entity2 = new BidirectionalManyToOneJoinColumnEntity("Mi Nick 2", array[0]);
        BidirectionalManyToOneJoinColumnEntity[] entityArray = {entity, entity2};
        array[0].setBidirectionalManyToOneJoinColumnEntityList(Arrays.asList(entityArray));
        bidirectionalManyToOneJoinColumnDao.save(Arrays.asList(entityArray));

        System.out.println(">>>> BidirectionalManyToOneJoinColumnEntity:  " + bidirectionalManyToOneJoinColumnDao.findOne(entity.getId()));
        System.out.println(">>>> OneToManyMappedByEntity:  " + oneToManyMappedByDao.findOne(array[0].getId()));
    }
}
