public abstract class Food implements Comparable<Food> {
    private String name;
    private double sellPrice;
    private int daysToMature;
    private int daysSincePotted;
    private int requiredArea;
    // Preferred soil is not defined here as it's specific to subclasses

    public Food(String name, double sellPrice, int daysToMature, int requiredArea) {
        this.name = name;
        this.sellPrice = sellPrice;
        this.daysToMature = daysToMature;
        this.requiredArea = requiredArea;
        this.daysSincePotted = 0;
    }

    public abstract void grow(Soil soil);

    public double grow() {
        daysSincePotted++;
        return Math.min(1.00, (double) daysSincePotted / daysToMature);
    }

    public int getRequiredArea() {
        return requiredArea;
    }

    public boolean isReadyToHarvest() {
        return daysSincePotted >= daysToMature;
    }

    public int getDaysSincePotted() {
        return daysSincePotted;
    }



    @Override
    public String toString() {
        return String.format("%s - %d/%d days", name, daysSincePotted, daysToMature);
    }

    @Override
    public int compareTo(Food other) {
        return Double.compare(other.sellPrice, this.sellPrice);
    }
}
