package animals;

import animals.Animal;
import food.Food;

public abstract class Carnivore extends Animal {

    public Carnivore(String name) {
        super(name);
        type = "Хищник";
    }

    @Override
    public boolean eat(Food food) {
        if (food.equals(Food.MEAT)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
