package assignment_2;

import java.util.Random;

// Abstract Product: Asteroids
interface AbstractAsteroid {
    void show();
}

// Concrete Products: IceAsteroid, IronAsteroid, RockyAsteroid, SiliconAsteroid, DiamondAsteroid, GoldAsteroid, CrystalAsteroid
class IceAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Ice Asteroid popped up");
    }
}

class IronAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Iron Asteroid popped up");
    }
}

class RockyAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Rocky Asteroid popped up");
    }
}

class SiliconAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Silicon Asteroid popped up");
    }
}

class DiamondAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Diamond Asteroid popped up");
    }
}

class GoldAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Gold Asteroid popped up");
    }
}

class CrystalAsteroid implements AbstractAsteroid {
    public void show() {
        System.out.println("Crystal Asteroid popped up");
    }
}

// Abstract Product: Debris Fields
interface AbstractDebrisField {
    void show();
}

// Concrete Products: DynamicDebrisField, PersistentDebrisField, StaticDebrisField, ExplosiveDebrisField, MagneticDebrisField, ToxicDebrisField
class DynamicDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Dynamic Debris Field appeared");
    }
}

class PersistentDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Persistent Debris Field appeared");
    }
}

class StaticDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Static Debris Field appeared");
    }
}

class ExplosiveDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Explosive Debris Field appeared");
    }
}

class MagneticDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Magnetic Debris Field appeared");
    }
}

class ToxicDebrisField implements AbstractDebrisField {
    public void show() {
        System.out.println("Toxic Debris Field appeared");
    }
}

// Abstract Factory: ObstacleFactory
interface ObstacleFactory {
    AbstractAsteroid createAsteroid();
    AbstractDebrisField createDebrisField();
}

// Concrete Factories: Level1Factory, Level2Factory, Level3Factory, Level4Factory, Level5Factory
class Level1Factory implements ObstacleFactory {
    public AbstractAsteroid createAsteroid() {
        return new IceAsteroid();
    }

    public AbstractDebrisField createDebrisField() {
        return new StaticDebrisField();
    }
}

class Level2Factory implements ObstacleFactory {
    public AbstractAsteroid createAsteroid() {
        return new SiliconAsteroid();
    }

    public AbstractDebrisField createDebrisField() {
        return new DynamicDebrisField();
    }
}

class Level3Factory implements ObstacleFactory {
    public AbstractAsteroid createAsteroid() {
        return new DiamondAsteroid();
    }

    public AbstractDebrisField createDebrisField() {
        return new ExplosiveDebrisField();
    }
}

class Level4Factory implements ObstacleFactory {
    public AbstractAsteroid createAsteroid() {
        return new GoldAsteroid();
    }

    public AbstractDebrisField createDebrisField() {
        return new MagneticDebrisField();
    }
}

class Level5Factory implements ObstacleFactory {
    public AbstractAsteroid createAsteroid() {
        return new CrystalAsteroid();
    }

    public AbstractDebrisField createDebrisField() {
        return new ToxicDebrisField();
    }
}

// Client
class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Randomly select a level
        int level = random.nextInt(5) + 1;

        // Randomly generate a score
        int score = random.nextInt(2001);

        // Instantiate the appropriate factory based on the level
        ObstacleFactory factory = switch (level) {
            case 1 -> new Level1Factory();
            case 2 -> new Level2Factory();
            case 3 -> new Level3Factory();
            case 4 -> new Level4Factory();
            case 5 -> new Level5Factory();
            default -> throw new IllegalArgumentException("Invalid level: " + level);
        };

        // Create an asteroid using the factory
        AbstractAsteroid asteroid = factory.createAsteroid();
        asteroid.show();

        // Create a debris field using the factory
        AbstractDebrisField debrisField = factory.createDebrisField();
        debrisField.show();
    }
}
