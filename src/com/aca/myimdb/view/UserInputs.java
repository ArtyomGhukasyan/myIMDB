package com.aca.myimdb.view;

import com.aca.myimdb.databases.Database;
import com.aca.myimdb.model.users.User;

import java.io.IOException;
import java.util.ArrayList;

public class UserInputs {


    public static void login() {

        String username = Reader.getInput("Please enter username for login");
        while (!usernameExist(username, Database.users)) {
            username = Reader.getInput("There is no user with such username, try again");
        }

        String password = Reader.getInput("Enter password");
        int id = User.getIdByUsername(username, Database.users);

        String userString = id + "/" + username + "/" + password;


        while (!userExist(userString, Database.users)){
            password = Reader.getInput("Wrong password, try again");
            userString = id + "/" + username + "/" + password;
        }

        System.out.println(username + ", you are welcome!");
    }

    public static void registerNewUser() {

        String username = Reader.getInput("Please enter username for registration");

        while (usernameExist(username, Database.users)) {
            username = Reader.getInput("This username is taken, please chose another one");
        }

        String password = Reader.getInput("Please type your password");

        User user = new User(password);
        user.setUsername(username);
        user.generateId(Database.users);

        try {
            Database.addUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean usernameExist(String user, ArrayList<User> list) {

        for (User us : list) {
            if (us.getUsername().equalsIgnoreCase(user)) {
                return true;
            }
        }
        return false;
    }

    private static boolean userExist(String userString, ArrayList<User> list) {

        for (User us : list) {
            if (us.getStringForDatabase().equals(userString)) {
                return true;
            }
        }
        return false;
    }
}
