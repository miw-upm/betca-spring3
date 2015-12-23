package spring.persistence.entities;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "unrelatedentity")//nombre por defecto de la tabla
public class UnRelatedEntity {

    public static final String TRANSIENT = "no persistent";

    @Id
    @GeneratedValue
    private int id;

    //nombre por defecto de la columna el nombre del atributo
    @Column(name="KCIN", unique = true, nullable = false, length = 30)
    private String nick;

    @Enumerated(EnumType.STRING)
    @Column(length=20)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP) //Fecha y hora //TemporalType.DATE Solo fecha
    private Calendar bornDate;

    @Lob
    private String large;

    private String[] strings; //ArrayList funciona igual

    //Se Almacena en otra tabla
    @ElementCollection(fetch=FetchType.LAZY)//Perezoso
    @CollectionTable(name="unrelatedentity_list")//opcional el nombre de la tabla a utilizar
    private List<String> list;
    
    @Transient
    private String noPersistent;

    public UnRelatedEntity() {
    }

    public UnRelatedEntity(String nick, Gender gender, Calendar bornDate, String large, String[] strings, List<String> list,
            String noPersistent) {
        super();
        this.nick = nick;
        this.gender = gender;
        this.bornDate = bornDate;
        this.large = large;
        this.strings = strings;
        this.list = list;
        this.noPersistent = noPersistent;
    }

    @Override
    public String toString() {
        return "UnRelatedEntity [id=" + id + ", nick=" + nick + ", gender=" + gender + ", bornDate=" + formatBornDate() + ", large=" + large
                + ", strings=" + Arrays.toString(strings) + ", list=" + list + ", noPersistent=" + noPersistent + "]";
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
            UnRelatedEntity other = (UnRelatedEntity) obj;
            return nick.equals(other.nick);
        }
    }

    public String formatBornDate() {
        String month = bornDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        return bornDate.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + bornDate.get(Calendar.YEAR);
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getBornDate() {
        return bornDate;
    }

    public String getLarge() {
        return large;
    }

    public String[] getStrings() {
        return strings;
    }

    public List<String> getList() {
        return list;
    }

    public String getNoPersistent() {
        return noPersistent;
    }
}
