package live.clover.api.impl;

import live.clover.api.AnimalSay;

/**
 * @author weibb
 */
public class CatSay implements AnimalSay {
    @Override
    public void say() {
        System.out.println("the cat say: miao miao miao!");
    }
}
