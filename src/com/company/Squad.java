package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by tyuly on 21.11.2016.
 * class squad of warriors
 */
public class Squad implements Cloneable {
    Warrior warriors [];
    private String name;
    public static  int l = 1;

    Squad (int k, Warrior warriors []) {
        this.warriors = new Warrior [k];
        this.warriors = warriors;
        this.name = "Squad " + l;
        for (int i = 0; i < warriors.length; i++) {
            warriors [i].setSquatName(name);
        }
        l++;
    }

    /**
     *
     * @param i numberof element warriors
     * @return warrior
     */
    public Warrior getWarrior(int i) {
        return warriors[i];
    }

    /**
     * method to return random warrior from squad
     * @return Warrior
     */
    public Warrior getRandomWarrior() {
        Random random = new Random();
        int k;
        do {
            k = random.nextInt(warriors.length);
        }
        while (!warriors[k].isAlive());
        return warriors[k];
    }

    /**
     * method to check has alive warriors
     * @return boolean
     */
    public boolean hasAliveWarriors() {
        for (int i = 0; i < warriors.length ; i++) {
            if (warriors[i].isAlive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Squad clone() {
        try {
            Squad clone = (Squad) super.clone();
            clone.warriors = new Warrior[warriors.length];
           for (int i = 0; i < clone.warriors.length; i++) {
               clone.warriors[i] = warriors[i].clone();
           }
            return clone;
        }
        catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

}
