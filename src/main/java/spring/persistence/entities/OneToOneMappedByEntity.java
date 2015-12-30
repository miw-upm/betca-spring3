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

    private String value;

    @OneToOne(mappedBy = "oneToOneMappedByEntity")
    private BidirectionalOneToOneJoinColumnEntity bidirectionalOneToOneJoinColumnEntity;

    public OneToOneMappedByEntity() {
    }

    public OneToOneMappedByEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToOneMappedByEntity [value=" + value + ", bidirectionalOneToOneJoinColumnEntityId="
                + bidirectionalOneToOneJoinColumnEntity.getId() + "]";
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return id == ((OneToOneMappedByEntity) obj).id;
        }
    }

    public int getId() {
        return id;
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
