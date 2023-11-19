public class AppleFarm extends Farm {
    public AppleFarm(int area) {
        super(area, Soil.Loam);
    }

    @Override
    public boolean seedFood(Food food) {
        // Ensure only apples are seeded
        return super.seedFood(food);
    }
}