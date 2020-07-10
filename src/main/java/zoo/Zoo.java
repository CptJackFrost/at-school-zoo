package zoo;

import Enclosures.Enclosure;
import animals.Animal;
import animals.Eagle;
import animals.Lion;
import animals.Duck;
import animals.Giraffe;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import food.Food;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Zoo {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) throws IOException {


        ArrayList<Enclosure> enclosures = load();


        Enclosure first = enclosures.get(0);
        Enclosure second = enclosures.get(1);
        Enclosure third = enclosures.get(2);
        Enclosure fourth = enclosures.get(3);


        StringTokenizer st = new StringTokenizer("Михаил Павлович Терентьев", " ");
        System.out.println(st.nextToken() + " " + st.nextToken());
        System.out.println(st.nextToken() + "\n");

        GregorianCalendar calendar = new GregorianCalendar();
        log.info("Запись от " + calendar.getTime());
        log.error("второй лог");

        first.addAnimal(new Lion("Чук"));
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
        System.out.println("\nЗавтрашняя дата: " + calendar.getTime());

        enclosures.set(0, first);
        enclosures.set(1, second);
        enclosures.set(2, third);
        enclosures.set(3, fourth);

        Writer writer = new FileWriter("save.json");
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Animal.class, new AnimalAdapter());
        gson.create().toJson(enclosures, writer);
        writer.close();
    }

    private static ArrayList<Enclosure> load() throws FileNotFoundException {
        Type listOfEnclosures = new TypeToken<ArrayList<Enclosure>>(){}.getType();
        GsonBuilder gson = new GsonBuilder();
        Reader reader = new FileReader("save.json");
        gson.registerTypeAdapter(Animal.class, new AnimalAdapter());
        ArrayList<Enclosure> output = gson.create().fromJson(reader, listOfEnclosures);
        return output;
    }

    private static class AnimalAdapter implements JsonSerializer<Animal>, JsonDeserializer<Animal> {

        @Override
        public JsonElement serialize(Animal src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject result = new JsonObject();
            result.add("classType", new JsonPrimitive(src.getClass().getSimpleName()));
            result.add("classProperties", context.serialize(src, src.getClass()));
            return result;
        }


        @Override
        public Animal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            String type = jsonObject.get("classType").getAsString();
            JsonElement element = jsonObject.get("classProperties");

            try {
                String thePackage = "animals.";
                return context.deserialize(element, Class.forName(thePackage + type));
            } catch (ClassNotFoundException cnfe) {
                throw new JsonParseException("Unknown element type: " + type, cnfe);
            }
        }
    }

}

