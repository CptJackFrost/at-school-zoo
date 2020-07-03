package animals.herbivore;

import animals.Animal;
import food.Food;
import food.herb.Herb;

public abstract class Herbivore extends Animal {

    public Herbivore(String name) {
        super(name);
        type = "Травоядное";
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Herb) {
            return true;
        } else {
            return false;
        }
    }

}
