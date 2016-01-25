package persistence.entities;

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

    private String value;

    @OneToMany(mappedBy = "oneToManyMappedByEntity", fetch = FetchType.EAGER)
    private List<BidirectionalManyToOneJoinColumnEntity> bidirectionalManyToOneJoinColumnEntityList;

    public OneToManyMappedByEntity() {
    }

    public OneToManyMappedByEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OneToManyMappedByEntity [id=" + id + ", value=" + value + ", bidirectionalManyToOneJoinColumnEntityList="
                + bidirectionalManyToOneJoinColumnEntityList + "]";
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
            return id == ((OneToManyMappedByEntity) obj).id;
        }
    }

    public int getId() {
        return id;
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
