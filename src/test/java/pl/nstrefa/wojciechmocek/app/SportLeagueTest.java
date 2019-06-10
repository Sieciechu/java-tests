package pl.nstrefa.wojciechmocek.app;

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

    @Test
    void teamsShouldBeStoredByNameAlphabeticalOrder() {
        // given
        var league = new SportLeague<FootballTeam>("premier league");
        var teamM = new FootballTeam("Manchester Utd");
        var teamA = new FootballTeam("A team");
        var teamZ = new FootballTeam("Z team");
        league.store(teamM);
        league.store(teamA);
        league.store(teamZ);

        // when
        FootballTeam[] teams = league.getUnmodifiableTeams().toArray(new FootballTeam[3]);

        // then
        assertSame(teamA.name, teams[0].name);
        assertSame(teamM.name, teams[1].name);
        assertSame(teamZ.name, teams[2].name);
    }
}