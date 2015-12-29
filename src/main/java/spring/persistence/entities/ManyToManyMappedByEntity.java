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

    private int number;

    private String value;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "manyToManyMappedByEntityList")
    private List<BidirectionalManyToManyEntity> bidirectionalManyToManyEntityList;

    public ManyToManyMappedByEntity() {
    }

    public ManyToManyMappedByEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ManyToManyMappedByEntity [id=" + id + ", number=" + number + ", value=" + value + "]";
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
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
