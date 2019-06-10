/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void whenRunThenOutputIsWrittenToWriter() {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);
        App app = new App(buffWriter);

        app.run();
        String expectedTeams = "Our league name is 'Premier league'. Below are teams:\n" +
            "Liverpool\n" +
            "London City\n" +
            "Manchaster Utd\n" +
            "Totenham\n";

        assertEquals(expectedTeams, stringWriter.toString());
    }
}
