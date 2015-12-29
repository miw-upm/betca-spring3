package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ManyToOneJoinColumnEntity {

    @Id
    @GeneratedValue
    private int id;

    private String value;

    @ManyToOne
    @JoinColumn
    private BidirectionalOneToManyMappedByEntity bidirectionalOneToManyMappedByEntity;

    public ManyToOneJoinColumnEntity() {
    }

    public ManyToOneJoinColumnEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ManyToOneJoinColumnEntity [id=" + id + ", value=" + value + ", bidirectionalOneToManyEntityId="
                + bidirectionalOneToManyMappedByEntity.getId() + "]";
    }

    public String getValue() {
        return value;
    }

    public BidirectionalOneToManyMappedByEntity getBidirectionalOneToManyMappedByEntity() {
        return bidirectionalOneToManyMappedByEntity;
    }

    public void setBidirectionalOneToManyMappedByEntity(BidirectionalOneToManyMappedByEntity bidirectionalOneToManyMappedByEntity) {
        this.bidirectionalOneToManyMappedByEntity = bidirectionalOneToManyMappedByEntity;
    }

}
