import java.util.ArrayList;

public class Farm {
    private int area;
    private Soil soilType;
    private ArrayList<Food> foods;

    public Farm(int area, Soil soilType) {
        this.area = area;
        this.soilType = soilType;
        this.foods = new ArrayList<>();
    }

    public boolean seedFood(Food food) {
        int requiredArea = food.getRequiredArea();
        if (this.availableArea() >= requiredArea) {
            foods.add(food);
            return true;
        }
        return false;
    }

    private int availableArea() {
        return area - foods.stream().mapToInt(Food::getRequiredArea).sum();
    }

    public boolean hasEnoughSpace(Food food) {
        int requiredArea = food.getRequiredArea();
        return this.availableArea() >= requiredArea;
    }


    public Food harvestFood(int index) {
        if (index < 0 || index >= foods.size()) {
            return null;
        }
        Food food = foods.get(index);
        if (food.isReadyToHarvest()) {
            foods.remove(index);
            return food;
        }
        return null;
    }

    public void overnightGrow() {
        for (Food food : foods) {
            food.grow(this.soilType);
        }
    }



}
