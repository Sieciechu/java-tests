package pl.nstrefa.wojciechmocek;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SportLeague<T extends Team> {

    private String name;
    private Set<T> teams = new TreeSet<>(Comparator.comparing(o -> o.name));

    public SportLeague(String name) {
        this.name = name;
    }

    public void store(T team) {
        teams.add(team);
    }

    public Set<T> getUnmodifiableTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public String getName() {
        return name;
    }
}
