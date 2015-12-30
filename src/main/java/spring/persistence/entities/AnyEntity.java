package spring.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AnyEntity {

    @Id
    @GeneratedValue
    private int id;

    private String value;

    public AnyEntity() {
    }

    public AnyEntity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnyEntity [id=" + id + ", value=" + value + "]";
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
            return id == ((AnyEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
