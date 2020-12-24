package services;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static User getUser() {
        User user = new User();
        user.setEmail("228");
        user.setSurname("glek");
        user.setName("kavo");
        return user;
    }

    public static List<User> getUserList() {
        User user = new User();
        user.setEmail("228");
        user.setSurname("glek");
        user.setName("kavo");
        User secondUser = new User();
        secondUser.setEmail("228");
        secondUser.setSurname("glek");
        secondUser.setName("kavo");
        User thirdUser = new User();
        thirdUser.setEmail("228");
        thirdUser.setSurname("glek");
        thirdUser.setName("kavo");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(secondUser);
        list.add(thirdUser);

        return list;
    }
}
