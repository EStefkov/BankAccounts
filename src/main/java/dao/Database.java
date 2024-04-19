package dao;
import java.util.ArrayList;
import entities.User;

public class Database {
    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static User getUserByTitularNames(String titularNames) {
        for (User user : users) {
            if (user.getTitularNames().equals(titularNames)) {
                return user;
            }
        }
        return null;
    }

    public static void updateUser(User newUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getTitularNames().equals(newUser.getTitularNames())) {
                users.set(i, newUser);
                break;
            }
        }
    }
}

