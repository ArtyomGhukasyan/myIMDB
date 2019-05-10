package com.aca.myimdb.model.teammembers;

import jdk.nashorn.internal.objects.NativeRegExp;

import java.util.ArrayList;

public class Actor extends TeamMember {

    @Override
    public Actor createTeamMemberFromString(String s){

        String[] teamMember = s.split("/");

        //name / age / movies
        //create new actor
        Actor actor = new Actor();
        //create new list of filmnames
        ArrayList<String> filmsList = new ArrayList<>();
        //split given string
        String[] teamMemberParts = s.split("/");

        actor.setName(teamMemberParts[0]);
        actor.setAge(Integer.parseInt(teamMemberParts[1]));

        for (int i = 2; i < teamMemberParts.length; i++) {
            filmsList.add(teamMemberParts[i]);
        }
        actor.setFilms(filmsList);
        return actor;
    }
}
