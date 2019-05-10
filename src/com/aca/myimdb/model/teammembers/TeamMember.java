package com.aca.myimdb.model.teammembers;

import com.aca.myimdb.model.films.Film;

import java.util.ArrayList;

public abstract class TeamMember {
    private String name;
    private int age;
    private ArrayList<String> filmNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getFilms() {
        return filmNames;
    }

    public void setFilms(ArrayList<String> filmNames) {
        this.filmNames = filmNames;
    }

    public String getFilmsString() {

        StringBuilder str = new StringBuilder();
        for (String film : filmNames) {
            str.append("/" + film);
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return name + "/" + age + getFilmsString();
    }

    public abstract TeamMember createTeamMemberFromString(String s);

    public String getStringForDatabase(){
        return toString();
    }
}
