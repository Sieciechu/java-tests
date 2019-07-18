package pl.nstrefa.wojciechmocek;

public class ForLoopTest {

    private static int numberOfTimesCalledGetNumbers = 0;
    private static int numberOfTimesCalledGetSize = 0;

    static void testIfForeachEvaluatesMethodEachTime() {
        for (int i : getNumbers()) {
//            System.out.println(i);
        }
//        System.out.println("getNumbers called " + numberOfTimesCalledGetNumbers + " times");
        assert 1 == numberOfTimesCalledGetNumbers;
        numberOfTimesCalledGetNumbers = 0;
    }

    static void testIfForLoopEvaluatesMethodEachTime() {
        for (int i=0; i<getSize(); ++i) {
//            System.out.println(i);
        }
//        System.out.println("getSize called " + numberOfTimesCalledGetSize + " times");
        assert 6 == numberOfTimesCalledGetSize;
        numberOfTimesCalledGetSize = 0;
    }

    private static int[] getNumbers() {
        ++numberOfTimesCalledGetNumbers;
        return new int[]{1,2,3,4,5};
    }

    private static int getSize() {
        ++numberOfTimesCalledGetSize;
        return 5;
    }
}
