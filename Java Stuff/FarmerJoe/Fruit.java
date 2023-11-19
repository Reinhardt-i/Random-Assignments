public class Fruit extends Food {
    private static final Soil PREFERRED_SOIL = Soil.Silt;

    public Fruit(String name, double sellPrice, int daysToMature, int requiredArea) {
        super(name, sellPrice, daysToMature, requiredArea);
    }

    @Override
    public void grow(Soil soil) {
        if (soil == PREFERRED_SOIL) {
            super.grow();
        } else {
            if (super.getDaysSincePotted() % 3 == 0) {
                super.grow();
            }
        }
    }


}