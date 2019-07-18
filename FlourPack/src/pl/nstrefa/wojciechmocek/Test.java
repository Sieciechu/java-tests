package pl.nstrefa.wojciechmocek;

/**
 * Test asserts if given years are leap
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("Testing FlourPacker:");

        FlourPacker flourPacker = new FlourPacker(5, 1);

        assert true == flourPacker.canPack(0,0,0);
        assert true == flourPacker.canPack(0,1,1);
        assert true == flourPacker.canPack(0,10,2);

        assert true == flourPacker.canPack(1,0,5);
        assert true == flourPacker.canPack(20,0,5);
        assert true == flourPacker.canPack(2,0,10);

        assert true == flourPacker.canPack(1,1,1);
        assert true == flourPacker.canPack(2,1,1);
        assert true == flourPacker.canPack(2,10,11);

        assert false == flourPacker.canPack(0,0,1);
        assert false == flourPacker.canPack(1,0,1);
        assert false == flourPacker.canPack(1,0,4);
        assert false == flourPacker.canPack(1,0,6);
        assert false == flourPacker.canPack(20,0,7);
        assert false == flourPacker.canPack(0,10,20);
        assert false == flourPacker.canPack(2,1,13);
        assert false == flourPacker.canPack(5,3,24);

        System.out.println("All assertions are met");

    }
}
