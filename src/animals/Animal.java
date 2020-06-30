package animals;

import food.Food;

public abstract class Animal {

    private final String name;
    protected String type;
    protected String species;
    protected String noise;

    public Animal(String name){
        this.name = name;
    }

    public abstract boolean eat(Food food);

    public String getName(){
        return this.name;
    }

    public String getType() {
        return type;
    }

    public String getSpecies(){
        return species;
    }

    public void makeNoise(){
        System.out.println(species + " " + name + ": " + noise);
    }

}
