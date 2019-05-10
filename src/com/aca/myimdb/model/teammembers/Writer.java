package com.aca.myimdb.model.teammembers;

import java.util.ArrayList;

public class Writer extends TeamMember {

    @Override
    public Writer createTeamMemberFromString(String s){

        String[] teamMember = s.split("/");

        //name / age / movies

        //create new actor
        Writer writer = new Writer();
        //create new list of film names
        ArrayList<String> filmsList = new ArrayList<>();
        //split given string
        String[] teamMemberParts = s.split("/");

        writer.setName(teamMemberParts[0]);
        writer.setAge(Integer.parseInt(teamMemberParts[1]));
        for (int i = 2; i < teamMemberParts.length; i++) {
            filmsList.add(teamMemberParts[i]);
        }
        writer.setFilms(filmsList);
        return writer;
    }
}
