package com.aca.myimdb.model.films;

import com.aca.myimdb.model.teammembers.TeamMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Season extends Film {

    private ArrayList<Episode> episodes;
    private int seasonNumber;
    private int episodeCount;
    private HashMap<String, HashSet<TeamMember>> SeasonCrew;
}
