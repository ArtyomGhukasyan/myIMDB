package com.aca.myimdb.model.films;

import com.aca.myimdb.model.teammembers.TeamMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Series extends Film {

    private ArrayList<Season> seasons;
    private HashMap<String, HashSet<TeamMember>> seriesCrew;
    private int seasonCount;

}
