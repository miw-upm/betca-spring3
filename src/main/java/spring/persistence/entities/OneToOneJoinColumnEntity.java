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

    private String value;

    @OneToOne
    @JoinColumn
    private BidirectionalOneToOneMappedByEntity bidirectionalOneToOneMappedByEntity;

    public OneToOneJoinColumnEntity() {
    }

    public OneToOneJoinColumnEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToOneJoinColumnEntity [value=" + value + ", BidirectionalOneToOneMappedByEntity="
                + bidirectionalOneToOneMappedByEntity.getId() + "]";
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
            return id == ((OneToOneJoinColumnEntity) obj).id;
        }
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
