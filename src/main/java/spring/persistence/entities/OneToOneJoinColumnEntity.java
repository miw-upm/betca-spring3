package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OneToOneJoinColumnEntity {

    @Id
    @GeneratedValue
    private int id;

    private int number;

    private String value;

    @OneToOne
    @JoinColumn
    private BidirectionalOneToOneMappedByEntity bidirectionalOneToOneMappedByEntity;

    public OneToOneJoinColumnEntity() {
    }

    public OneToOneJoinColumnEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToOneJoinColumnEntity [number=" + number + ", value=" + value
                + ", BidirectionalOneToOneMappedByEntity=" + bidirectionalOneToOneMappedByEntity.getId() + "]";
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public BidirectionalOneToOneMappedByEntity getBidirectionalOneToOneMappedByEntity() {
        return bidirectionalOneToOneMappedByEntity;
    }

    public void setBidirectionalOneToOneMappedByEntity(BidirectionalOneToOneMappedByEntity bidirectionalOneToOneMappedByEntity) {
        this.bidirectionalOneToOneMappedByEntity = bidirectionalOneToOneMappedByEntity;
    }

}
