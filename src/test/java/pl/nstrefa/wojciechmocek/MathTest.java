
package pl.nstrefa.wojciechmocek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class MathTest {

    @ParameterizedTest
    @MethodSource("naturalNumbersProvider")
    public void testSum(int n, int expectedSum) {
        Math math = new Math();

        Assertions.assertEquals(expectedSum, math.sumFromZeroToN(n));
    }

    private static Stream<Arguments> naturalNumbersProvider() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(5, 15),
            Arguments.of(10, 55)
        );
    }
}
