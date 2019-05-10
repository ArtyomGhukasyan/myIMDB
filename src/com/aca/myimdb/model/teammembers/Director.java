package com.aca.myimdb.model.teammembers;

import java.util.ArrayList;

public class Director extends TeamMember {

    @Override
    public Director createTeamMemberFromString(String s){

        String[] teamMember = s.split("/");

        //name / age / movies

        //create new actor
        Director director = new Director();
        //create new list of filmnames
        ArrayList<String> filmsList = new ArrayList<>();
        //split given string
        String[] teamMemberParts = s.split("/");

        director.setName(teamMemberParts[0]);
        director.setAge(Integer.parseInt(teamMemberParts[1]));
        for (int i = 2; i < teamMemberParts.length; i++) {
            filmsList.add(teamMemberParts[i]);
        }
        director.setFilms(filmsList);
        return director;
    }
}
