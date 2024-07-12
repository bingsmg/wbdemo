package live.clover.spi;

import live.clover.api.AnimalSay;

/**
 * service provider interface
 * @author weibb
 */
public class SPITest {
    public static void main(String[] args) {
        AnimalManagerLoader animalManagerLoader = AnimalManagerLoader.getInstance();
        for (AnimalSay animalSay : animalManagerLoader.getAnimalSays()) {
            animalSay.say();
        }
    }
}
