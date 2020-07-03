package animals.carnivore;

import animals.Animal;
import food.Food;
import food.meat.Meat;

public abstract class Carnivore extends Animal {

    protected Carnivore(String name){
        super(name);
        type = "Хищник";
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Meat) {
            return true;
        }
        else {
            System.out.println(species + " это не ест");
            return false;
        }
    }
}
