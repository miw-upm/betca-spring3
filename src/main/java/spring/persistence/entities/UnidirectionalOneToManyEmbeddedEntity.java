package spring.persistence.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidirectionalOneToManyEmbeddedEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nick;

    // 1:0..n
    private AnyClass[] anyClassArray;

    public UnidirectionalOneToManyEmbeddedEntity() {
    }

    public UnidirectionalOneToManyEmbeddedEntity(String nick, AnyClass[] anyClassArray) {
        this.nick = nick;
        this.anyClassArray = anyClassArray;
    }

    @Override
    public String toString() {
        return "UnidirectionalOneToManyEmbeddedEntity [id=" + id + ", nick=" + nick + ", anyClassArray=" + Arrays.toString(anyClassArray)
                + "]";
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
            return id == ((UnidirectionalOneToManyEmbeddedEntity) obj).id;
        }
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public AnyClass[] getAnyClassArray() {
        return anyClassArray;
    }

}
