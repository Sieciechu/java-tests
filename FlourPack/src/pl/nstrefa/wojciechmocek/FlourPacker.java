package pl.nstrefa.wojciechmocek;

class FlourPacker {

    private final int BIG_BAGS_KILOGRAM_WEIGHT;
    private final int SMALL_BAGS_KILOGRAM_WEIGHT;

    public FlourPacker() {
        BIG_BAGS_KILOGRAM_WEIGHT = 5;
        SMALL_BAGS_KILOGRAM_WEIGHT = 1;
    }

    public FlourPacker(int bigBagsKilogramWeight, int smallBagsKilogramWeight) {
        BIG_BAGS_KILOGRAM_WEIGHT = bigBagsKilogramWeight;
        SMALL_BAGS_KILOGRAM_WEIGHT = smallBagsKilogramWeight;
    }

    public boolean canPack(int bigBags, int smallBags, int kilogramsToPack) throws IllegalArgumentException {

        if (kilogramsToPack < 0 || smallBags < 0 || bigBags < 0) {
            throw new IllegalArgumentException("Weight cannot be less than zero");
        }

        int kilogramsLeft = kilogramsToPack;
        for (int i = 0; i < bigBags; ++i) {
            if (kilogramsLeft >= BIG_BAGS_KILOGRAM_WEIGHT) {
                kilogramsLeft -= BIG_BAGS_KILOGRAM_WEIGHT;
            }
        }
        for (int i = 0; i < smallBags && kilogramsLeft>=0; ++i) {
            if (kilogramsLeft >= SMALL_BAGS_KILOGRAM_WEIGHT) {
                kilogramsLeft -= SMALL_BAGS_KILOGRAM_WEIGHT;
            }
        }

        return kilogramsLeft<=0;
    }
}
