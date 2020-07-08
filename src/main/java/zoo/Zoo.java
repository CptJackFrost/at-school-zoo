package zoo;

import Enclosures.Enclosure;
import animals.carnivore.Eagle;
import animals.carnivore.Lion;
import animals.herbivore.Duck;
import animals.herbivore.Giraffe;
import food.Food;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Zoo {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {

        Enclosure first = new Enclosure(3);
        Enclosure second = new Enclosure(2, "для уточек");
        Enclosure third = new Enclosure(4, "для травоядных");
        Enclosure fourth = new Enclosure(2, "для хищников");

        /*StringTokenizer st = new StringTokenizer("Михаил Павлович Терентьев", " ");
        System.out.println(st.nextToken() + " " + st.nextToken());
        System.out.println(st.nextToken() + "\n");*/

        GregorianCalendar calendar = new GregorianCalendar();
        log.info("Запись от " + calendar.getTime());
        log.error("второй лог");


        /*first.addAnimal(new Lion("Чук"));
        first.addAnimal(new Lion("Гек"));
        first.addAnimal(new Eagle("Крылан"));
        first.poke("Лев");
        first.poke("Крылан");
        first.poke("Орангутан");
        System.out.println("--------------");

        second.addAnimal(new Duck("Кряква"));
        second.addAnimal(new Duck("Брюква"));
        second.seeAnimals();
        second.removeAnimal("Кряква");
        second.seeAnimals();
        second.feedAnimals(Food.GRAIN);
        second.feedAnimals(Food.MEAT);
        System.out.println("--------------");

        third.addAnimal(new Giraffe("Кранчик"));
        third.addAnimal(new Lion("Какой-то залетный"));
        third.addAnimal(new Giraffe("Башня"));
        third.addAnimal(new Duck("Газетная"));
        third.addAnimal(new Duck("Безымянная"));
        third.seeAnimals();
        System.out.println("--------------");

        fourth.addAnimal(new Giraffe("Помещенный по ошибке"));
        fourth.addAnimal(new Eagle("Сэм"));
        fourth.removeAnimal(0);
        fourth.addAnimal(new Eagle("Сэм"));
        fourth.addAnimal(new Eagle("Пират Глазастик"));
        fourth.addAnimal(new Eagle("Лишний"));
        fourth.seeAnimals();
        System.out.println("--------------");


        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("\nЗавтрашняя дата: " + calendar.getTime());*/


    }
}

