package Enclosures;

import animals.Animal;
import food.Food;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



public class Enclosure {
    private static final Logger log = LogManager.getLogger();

    /*
    Не понял по заданию, нужно ли создавать два разных класса вольеров,
    поэтому тип вольеров только один, но с проверкой, кто в нем, чтобы нельзя было поселить волка к овцам или наоборот
     */

    private final int capacity;
    private final ArrayList<Animal> animals;
    private final String name;

    public Enclosure(int capacity) {
        if (capacity <= 0) {
            this.capacity = 1;
        } else {
            this.capacity = capacity;
        }
        animals = new ArrayList<>();
        this.name = "";
    }

    public Enclosure(int capacity, String name) {
        this.capacity = capacity;
        animals = new ArrayList<>();
        this.name = name;
    }

    /*
    Та самая проверка. Сравнивает тип добавляемого животного с типом первого обитателя.
    Или просто разрешает, если вольер пустой
    */

    private boolean checkHabitats(Animal animal) {
        boolean permission = false;
        if (animals.size() == 0 || animals.get(0).getType().equals(animal.getType())) {
            permission = true;
        }
        return permission;
    }

    public void addAnimal(Animal animal) {
        if (animals.size() >= capacity) {
            System.out.println("Невозможно заселить - вольер переполнен");
        } else if (!checkHabitats(animal)) {
            System.out.println("Нельзя заселять хищников и травоядных в один вольер");
        } else {
            animals.add(animal);
            System.out.println(animal.getSpecies() + " " + animal.getName() + " теперь в вольере " + name);
        }
    }

    public void removeAnimal(int i) {
        if (animals.size() != 0) {
            System.out.println(animals.get(i).getName() + " больше не в вольере " + this.name);
            animals.remove(i);
        }
    }

    //а эта перегрузка уберет из вольера животнное с конкретной кличкой
    public void removeAnimal(String name) {
        ArrayList<Animal> copy = new ArrayList(animals);
        if (animals.size() != 0) {
            int i;
            boolean isItHere = false;
            for (Animal animal : copy) {
                if (animal.getName().equals(name)) {
                    i = copy.indexOf(animal);
                    isItHere = true;
                    removeAnimal(i);
                }
            }
            if (!isItHere) {
                System.out.println("А такого животного в этом вольере нет");
            }
        }
    }

    public void feedAnimals(Food food) {
        boolean allAreFed = true;
        for (Animal animal : animals) {
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                log.error(animal.getSpecies() + " не ест это");
                allAreFed = false;
                break;
            }
        }
        if (allAreFed) {
            System.out.println("Все животные накормлены");
        }

    }

    public void seeAnimals() {
        if (animals.size() == 0) {
            System.out.println("Вольер пуст");
        } else {
            System.out.println("В вольере " + name + " содержатся:");
            for (Animal habitat : animals) {
                System.out.println(habitat.getSpecies() + " " + habitat.getName());
            }
        }
    }

    //передать можно кличку - или вид животного
    public void poke(String animal) {
        boolean istItHere = false;
        for (Animal habitat : animals) {
            if (habitat.getName().equals(animal) || habitat.getSpecies().equals(animal)) {
                istItHere = true;
                habitat.makeNoise();
            }
        }
        if (!istItHere) {
            System.out.println("А такого животного в этом вольере нет");
        }
    }

}
