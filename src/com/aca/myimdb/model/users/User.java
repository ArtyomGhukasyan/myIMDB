package com.aca.myimdb.model.users;

import com.aca.myimdb.databases.Database;
import com.aca.myimdb.model.films.Film;

import java.util.ArrayList;


public class User {
    private String username;
    private String password;
    private int id;

    public User(String password) {
        this.password = password;
    }

    public void rateMovie(Film film, int rate) {
        film.setVoteCount(film.getVoteCount() + 1);
        film.setVotesum(film.getVotesum() + rate);
        film.setRating((double) film.getVotesum() / film.getVoteCount());

    }

    public Film searchForMovie(String title) {

        for (Film movie : Database.films) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }

        System.out.println("there is no such movie");
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void generateId(ArrayList<User> list) {

        ArrayList<Integer> idList = new ArrayList<>();

        for (User user : list) {
            idList.add(user.getId());
        }

        int max = idList.get(0);
        for (int i = 1; i < idList.size(); i++) {
            if (max < idList.get(i)){
                max = idList.get(i);
            }
        }
        id = max+1;

    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", id: " + id;
    }

    public String getStringForDatabase() {
        return id + "/" + username + "/" + password;
    }

    public static User createUserFromString(String s) {

        String[] userParts = s.split("/");

        //id / username / password
        User user = new User(userParts[2]);
        user.setId(Integer.parseInt(userParts[0]));
        user.setUsername(userParts[1]);
        return user;
    }

    public static Admin createAdminFromString(String s) {

        String[] userParts = s.split("/");
        //id / username / password
        Admin admin = new Admin(userParts[2]);
        admin.setId(Integer.parseInt(userParts[0]));
        admin.setUsername(userParts[1]);
        return admin;
    }

    public static int getIdByUsername(String uName, ArrayList<User> userList) {

        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(uName)) {
                return user.getId();
            }
        }
        return -1;
    }
}
