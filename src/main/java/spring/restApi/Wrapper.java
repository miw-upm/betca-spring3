package spring.restApi;

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
    public String toString() {
        return "Wrapper [id=" + id + ", name=" + name + ", gender=" + gender + ", bornDate=" + bornDate.getTime() + "]";
    }

}
