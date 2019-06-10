package pl.nstrefa.wojciechmocek;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SportLeague<T extends Team> {

    private String name;
    private Set<T> teams = new TreeSet<>(new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.name.compareTo(o2.name);
        }
    });

    public SportLeague(String name) {
        this.name = name;
    }

    public void store(T team) {
        teams.add(team);
    }

    public Set<T> getUnmodifiableTeams() {
        return Collections.unmodifiableSet(teams);
    }


}
