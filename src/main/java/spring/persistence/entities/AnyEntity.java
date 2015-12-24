package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnyEntity {

    @Id
    @GeneratedValue
    private int id;

    private int number;
    
    private String value;
   
    public AnyEntity() {
    }

    public AnyEntity(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnyEntity [id=" + id + ", number=" + number + ", value=" + value + "]";
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
            AnyEntity other = (AnyEntity) obj;
            return id == other.id;
        }
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

}
