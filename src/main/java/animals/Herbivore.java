package animals;

import animals.Animal;
import food.Food;

public abstract class Herbivore extends Animal {

    public Herbivore(String name) {
        super(name);
        type = "Травоядное";
    }

    @Override
    public boolean eat(Food food) {
        if (food.equals(Food.LEAFS) || food.equals(Food.GRAIN)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
