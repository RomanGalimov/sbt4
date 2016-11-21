package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by tyuly on 21.11.2016.
 * class squad of warriors
 */
public class Squad implements Cloneable {
    Warrior warriors [] = new Warrior [5];
    private String name;

    Squad (String name, Warrior warriors [] ) {
        this.warriors = warriors;
        this.name = name;
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
        while (warriors[k].isAlive() != true);
        return warriors[k];
    }

    /**
     * method to check has alive warriors
     * @return boolean
     */
    public boolean hasAliveWarriors() {
        boolean alive = false;
        for (int i = 0; i < warriors.length ; i++) {
            if (warriors[i].isAlive() == true) {
                alive = true;
                break;
            }
            else {
                alive = false;
            }
        }
        return alive;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Squad clone() {
        try {
            Squad clone = (Squad) super.clone();
            clone.warriors = new Warrior[5];
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
