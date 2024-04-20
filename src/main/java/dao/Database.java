package dao;

import java.util.ArrayList;
import entities.User;

public class Database {
    private static ArrayList<User> users = new ArrayList<>();
    private static int idCounter = 1;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static void updateUser(User newUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId() == newUser.getId()) {
                users.set(i, newUser);
                break;
            }
        }
    }
}
