package com.aca.myimdb.controller;

import com.aca.myimdb.databases.Database;
import com.aca.myimdb.model.teammembers.Actor;
import com.aca.myimdb.model.teammembers.Director;
import com.aca.myimdb.model.teammembers.TeamMember;
import com.aca.myimdb.view.Reader;
import com.aca.myimdb.view.UserInputs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public void start() {

        //init databases
        Database.initialize();

        int answer=0;

        while (answer != 1 && answer !=2){
            answer = Reader.getInputInt("Press 1 to login or 2 to register");
        }
        if (answer == 1) {
            UserInputs.login();
        } else if (answer == 2) {
            UserInputs.registerNewUser();
        }
    }

    public <T extends TeamMember> void addTeamMember(T teammember) {

        FileWriter fileWriter = null;
        File database;

        if (teammember instanceof Actor) {
            database = new File("src/com/aca/myimdb/databases/actors.txt");
        } else if (teammember instanceof Director) {
            database = new File("src/com/aca/myimdb/databases/directors.txt");
        } else {
            database = new File("src/com/aca/myimdb/databases/writers.txt");
        }

        try {
            fileWriter = new FileWriter(database, true);
            fileWriter.write("\n" + teammember.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
