package spring.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ManyToManyMappedByEntity {

    @Id
    @GeneratedValue
    private int id;

    private String value;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "manyToManyMappedByEntityList")
    private List<BidirectionalManyToManyEntity> bidirectionalManyToManyEntityList;

    public ManyToManyMappedByEntity() {
    }

    public ManyToManyMappedByEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ManyToManyMappedByEntity [id=" + id + ", value=" + value + "]";
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public List<BidirectionalManyToManyEntity> getBidirectionalManyToManyEntityList() {
        return bidirectionalManyToManyEntityList;
    }

    public void setBidirectionalManyToManyEntityList(List<BidirectionalManyToManyEntity> bidirectionalManyToManyEntityList) {
        this.bidirectionalManyToManyEntityList = bidirectionalManyToManyEntityList;
    }

}
