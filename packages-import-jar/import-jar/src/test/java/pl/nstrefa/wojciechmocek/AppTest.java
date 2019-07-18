/*
 * This project is about to use imported jar file
 */
package pl.nstrefa.wojciechmocek;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    @Test public void testAppRuns() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App app = new App();

        app.sum(3);

        Assert.assertEquals("6\n", baos.toString());
    }
}
