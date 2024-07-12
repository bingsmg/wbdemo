package live.clover.api.impl;

import live.clover.api.AnimalSay;

/**
 * @author weibb
 */
public class DogSay implements AnimalSay {
    @Override
    public void say() {
        System.out.println("the dog say: wang wang wang!");
    }
}
