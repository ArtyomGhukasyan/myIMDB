package com.aca.myimdb.model.films;

import com.aca.myimdb.model.teammembers.Actor;
import com.aca.myimdb.model.teammembers.Director;
import com.aca.myimdb.model.teammembers.TeamMember;
import com.aca.myimdb.model.teammembers.Writer;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Film {

    private String title;
    private String description;
    private double rating;
    private int voteCount;
    private int votesum;
    private ArrayList<Genre> genrelist;
    private LocalDate premiereDate;
    private ArrayList<TeamMember> actors;
    private ArrayList<TeamMember> directors;
    private ArrayList<TeamMember> writers;
    private double duration;


    public ArrayList<TeamMember> getActors() {
        return actors;
    }

    public void setActors(ArrayList<TeamMember> actors) {
        this.actors = actors;
    }

    public ArrayList<TeamMember> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<TeamMember> directors) {
        this.directors = directors;
    }

    public ArrayList<TeamMember> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<TeamMember> writers) {
        this.writers = writers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVotesum() {
        return votesum;
    }

    public void setVotesum(int votesum) {
        this.votesum = votesum;
    }

    public ArrayList<Genre> getGenrelist() {
        return genrelist;
    }

    public void setGenrelist(ArrayList<Genre> genrelist) {
        this.genrelist = genrelist;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStringForDatabase() {
        return title + "/" + rating + "/" + genreListToString()
                + "/" + premiereDate.toString() + actorsListToString() +
                directorsListToString() + writersListToString() + duration;
    }

    public Film getFilmFromString(String s){

        String[] filmInfo = s.split("/");

        //title / rating / genres / premieredate / actors / directors / writers / duration

        //create new actor
        Film film = new Movie();
        film.setTitle(filmInfo[0]);
        film.setRating(Double.parseDouble(filmInfo[1]));

        String[] genres = filmInfo[2].split("-");
        for (String str: genres) {
            genrelist.add(parseStringToGenre(str));
        }
        film.setPremiereDate(LocalDate.parse(filmInfo[3]));

        String[] actorslist = filmInfo[4].split("-");
        for (String str: actorslist) {
            actors.add(new Actor().createTeamMemberFromString(str));
        }

        String[] directorslist = filmInfo[5].split("-");
        for (String str: directorslist) {
            directors.add(new Director().createTeamMemberFromString(str));
        }

        String[] writerslist = filmInfo[6].split("-");
        for (String str: writerslist) {
            writers.add(new Writer().createTeamMemberFromString(str));
        }

        film.setDuration(Double.parseDouble(filmInfo[7]));

        return film;
    }

    private String genreListToString() {
        StringBuilder str = new StringBuilder();
        for (Genre genre : genrelist) {
            str.append("/" + genre.toString() + "-");
        }
        return str.toString();
    }

    private String actorsListToString() {
        StringBuilder str = new StringBuilder();
        for (TeamMember tm : actors) {
            str.append("/" + tm.getName() + "-");
        }
        return str.toString();
    }

    private String directorsListToString() {
        StringBuilder str = new StringBuilder();
        for (TeamMember tm : directors) {
            str.append("/" + tm.getName() + "-");
        }
        return str.toString();
    }

    private String writersListToString() {
        StringBuilder str = new StringBuilder();
        for (TeamMember tm : writers) {
            str.append("/" + tm.getName() + "-");
        }
        return str.toString();
    }

    public String duration() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        hours = (int) (duration / 3600);
        minutes = (int) ((duration % 3600) / 60);
        seconds = (int) duration - hours * 3600 - minutes * 60;

        return "/" + hours + "h" + "-" + minutes + "m" + "-" + seconds;
    }

    public Genre parseStringToGenre(String string){
        //SCIFI, HORROR, COMEDY, ACTION, DRAMA, THRILLER, FANTASY, ADVENTURE, WAR, DOCUMENTAL;
        switch (string){
            case "SCIFI": return Genre.SCIFI;
            case "HORROR": return Genre.HORROR;
            case "COMEDY": return Genre.COMEDY;
            case "ACTION": return Genre.ACTION;
            case "DRAMA": return Genre.DRAMA;
            case "THRILLER": return Genre.THRILLER;
            case "FANTASY": return Genre.FANTASY;
            case "ADVENTURE": return Genre.ADVENTURE;
            case "WAR": return Genre.WAR;
            case "DOCUMENTAL": return Genre.DOCUMENTAL;
            default: return null;
        }
    }



}
