package spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userList;

    private int id;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1, "Jorge", 19, "j@gmail.com"));
        userList.add(new User(2, "Ana", 21, "a@gmail.com"));
        userList.add(new User(3, "Pedro", 22, "p@gmail.com"));
        id = 4;
    }

    public List<User> findAll() {
        return userList;
    }

    public User findOne(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean save(User user) {
        if (userList.contains(user)) {
            return false;
        } else {
            userList.add(user);
            return true;
        }
    }

    public void delete(int id) {
        userList.remove(new User(id));
    }

    public int generateId() {
        return id++;
    }

    public List<String> languages() {
        return Arrays.asList("es", "fr", "uk", "de");
    }
}
