package com.aca.myimdb.databases;

import com.aca.myimdb.model.films.Film;
import com.aca.myimdb.model.films.Movie;
import com.aca.myimdb.model.teammembers.Actor;
import com.aca.myimdb.model.teammembers.Director;
import com.aca.myimdb.model.teammembers.TeamMember;
import com.aca.myimdb.model.teammembers.Writer;
import com.aca.myimdb.model.users.Admin;
import com.aca.myimdb.model.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    public static ArrayList<TeamMember> actorsList;
    public static ArrayList<TeamMember> directorsList;
    public static ArrayList<TeamMember> writersList;
    public static ArrayList<User> users;
    public static ArrayList<Admin> admins;
    public static ArrayList<Film> films;

    public static void initialize() {
        actorsList = getActorsFromDb();
        directorsList = getDirectorsFromDb();
        writersList = getWritersFromDb();
        users = getUsersFromDb();
        admins = getAdminsFromDb();
        films = getFilmsFromDb();
    }

    public static void updateUsers(){
        users = getUsersFromDb();
    }

    private static ArrayList<Film> getFilmsFromDb() {

        ArrayList<Film> list = null;

        File database = new File("src/com/aca/myimdb/databases/films.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(new Movie().getFilmFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<TeamMember> getActorsFromDb() {
        ArrayList<TeamMember> list = new ArrayList<>();

        File database = new File("src/com/aca/myimdb/databases/actors.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(new Actor().createTeamMemberFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<TeamMember> getDirectorsFromDb() {
        ArrayList<TeamMember> list = new ArrayList<>();

        File database = new File("src/com/aca/myimdb/databases/directors.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(new Director().createTeamMemberFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<TeamMember> getWritersFromDb() {
        ArrayList<TeamMember> list = new ArrayList<>();

        File database = new File("src/com/aca/myimdb/databases/writers.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(new Writer().createTeamMemberFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<User> getUsersFromDb() {
        ArrayList<User> list = new ArrayList<>();

        File database = new File("src/com/aca/myimdb/databases/users.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(User.createUserFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<Admin> getAdminsFromDb() {
        ArrayList<Admin> list = new ArrayList<>();

        File database = new File("src/com/aca/myimdb/databases/admins.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(database);
            String string;

            while (scanner.hasNext()) {
                list.add(User.createAdminFromString(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addUser(User user) throws IOException {
        File database = new File("src/com/aca/myimdb/databases/users.txt");
        FileWriter writer = null;

        try {
            writer = new FileWriter(database,true);
            writer.write(System.lineSeparator());
            writer.write(user.getStringForDatabase());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }

        System.out.println("Congradulations, you'v registered!");

        Database.updateUsers();
    }

}
