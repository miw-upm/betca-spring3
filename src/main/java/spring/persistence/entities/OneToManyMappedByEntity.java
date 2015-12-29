package spring.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OneToManyMappedByEntity {

    @Id
    @GeneratedValue
    private int id;

    private int number;

    private String value;

    @OneToMany(mappedBy = "oneToManyMappedByEntity",fetch=FetchType.EAGER)
    private List<BidirectionalManyToOneJoinColumnEntity> bidirectionalManyToOneJoinColumnEntityList;

    public OneToManyMappedByEntity() {
    }

    public OneToManyMappedByEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToManyMappedByEntity [id=" + id + ", number=" + number + ", value=" + value
                + ", bidirectionalManyToOneJoinColumnEntityList=" + bidirectionalManyToOneJoinColumnEntityList + "]";
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

    public List<BidirectionalManyToOneJoinColumnEntity> getBidirectionalManyToOneJoinColumnEntityList() {
        return bidirectionalManyToOneJoinColumnEntityList;
    }

    public void setBidirectionalManyToOneJoinColumnEntityList(
            List<BidirectionalManyToOneJoinColumnEntity> bidirectionalManyToOneJoinColumnEntityList) {
        this.bidirectionalManyToOneJoinColumnEntityList = bidirectionalManyToOneJoinColumnEntityList;
    }

}
