package spring.persistence.entities;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class BidirectionalOneToOneEmbeddableEntity {

    private int number;
    
    private String value;
    
    @OneToOne
    private BidirectionalOneToOneEmbeddedEntity bidirectionalOneToOneEmbeddedEntity;
   
    public BidirectionalOneToOneEmbeddableEntity() {
    }

    public BidirectionalOneToOneEmbeddableEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }


    @Override
    public String toString() {
        return "BidirectionalOneToOneEmbeddableEntity [number=" + number + ", value=" + value + ", bidirectionalOneToOneEmbeddedEntityId="
                + bidirectionalOneToOneEmbeddedEntity.getId() + "]";
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public BidirectionalOneToOneEmbeddedEntity getBidirectionalOneToOneEmbeddedEntity() {
        return bidirectionalOneToOneEmbeddedEntity;
    }

    public void setBidirectionalOneToOneEmbeddedEntity(BidirectionalOneToOneEmbeddedEntity bidirectionalOneToOneEmbeddedEntity) {
        this.bidirectionalOneToOneEmbeddedEntity = bidirectionalOneToOneEmbeddedEntity;
    }    
    
}
