public class Farmer {
    private String name;
    private int energy;
    private Farm farm;

    public Farmer(String name) {
        this.name = name;
        this.energy = 100;
        this.farm = null;
    }

    public void sleep() {
        energy = Math.min(100, energy + 35);
        if (farm != null) {
            farm.overnightGrow();
        }
    }

    public boolean seedFood(Food food) {
        if (farm == null || !farm.hasEnoughSpace(food)) {
            return false;
        }

        int energyCost = food instanceof Vegetable ? 30 : 50;
        if (energy >= energyCost) {
            energy -= energyCost;
            return farm.seedFood(food);
        }
        return false;
    }

    public boolean buyFarm(Farm farm) {
        if (this.farm == null) {
            this.farm = farm;
            return true;
        }
        return false;
    }



}
