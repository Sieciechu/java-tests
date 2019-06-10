package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SportLeagueTest {

    @Test
    void whenStoreTeamThenTeamIsStored() {
        // given
        var league = new SportLeague<FootballTeam>("premier league");
        var team1 = new FootballTeam("Manchester Utd");

        // when
        league.store(team1);

        // then
        assertTrue(league.getUnmodifiableTeams().contains(team1));

    }

    @Test
    void whenGetUnmodifiableTeamsItShouldBeImpossibleToModifyThem() {
        // given
        var league = new SportLeague<FootballTeam>("premier league");
        var team1 = new FootballTeam("Manchester Utd");
        league.store(team1);

        // when-then
        Set<FootballTeam> teams = league.getUnmodifiableTeams();
        assertThrows(
            UnsupportedOperationException.class,
            () -> teams.add(new FootballTeam("New team"))
        );
    }
}