package restApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Wrapper {

    private int id;

    private String name;

    private Gender gender;

    private Calendar bornDate;

    public Wrapper() {
    }

    public Wrapper(int id, String name, Gender gender, Calendar bornDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bornDate = bornDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Calendar getBornDate() {
        return bornDate;
    }

    public void setBornDate(Calendar bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return id == ((Wrapper) obj).id;
    }

    @Override
    public String toString() {
        String dayString = new SimpleDateFormat("dd-MMM-yyyy").format(bornDate.getTime());
        return "Wrapper [id=" + id + ", name=" + name + ", gender=" + gender + ", bornDate=" + dayString + "]";
    }

}
