package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OneToOneMappedByEntity {

    @Id
    @GeneratedValue
    private int id;

    private int number;

    private String value;

    @OneToOne(mappedBy = "oneToOneMappedByEntity")
    private BidirectionalOneToOneJoinColumnEntity bidirectionalOneToOneJoinColumnEntity;

    public OneToOneMappedByEntity() {
    }

    public OneToOneMappedByEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToOneMappedByEntity [number=" + number + ", value=" + value
                + ", bidirectionalOneToOneJoinColumnEntityId=" + bidirectionalOneToOneJoinColumnEntity.getId() + "]";
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

    public BidirectionalOneToOneJoinColumnEntity getBidirectionalOneToOneJoinColumnEntity() {
        return bidirectionalOneToOneJoinColumnEntity;
    }

    public void setBidirectionalOneToOneJoinColumnEntity(BidirectionalOneToOneJoinColumnEntity bidirectionalOneToOneJoinColumnEntity) {
        this.bidirectionalOneToOneJoinColumnEntity = bidirectionalOneToOneJoinColumnEntity;
    }

}
