package live.clover.spi;

import live.clover.api.AnimalSay;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author weibb
 */
public class AnimalManagerLoader {

   private static final AnimalManagerLoader INSTANCE = new AnimalManagerLoader();
   private final List<AnimalSay> animalSays;

   private AnimalManagerLoader() {
      animalSays = load();
   }

   private List<AnimalSay> load() {
      ArrayList<AnimalSay> animalSays = new ArrayList<>();
      ServiceLoader<AnimalSay> serviceLoader = ServiceLoader.load(AnimalSay.class);
       for (AnimalSay animalSay : serviceLoader) {
           animalSays.add(animalSay);
       }
      return animalSays;
   }

   public static AnimalManagerLoader getInstance() {
      return INSTANCE;
   }

   public List<AnimalSay> getAnimalSays() {
      return animalSays;
   }
}
