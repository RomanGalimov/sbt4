package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Battle {

    public static void main(String[] args) {
        Warrior war1;
        Warrior war2;
        Locale locale = new Locale.Builder().setLanguage("ru").setRegion("ru").build();
        Squad squad1 = new Squad("Squad1",new Warrior[] {new Viking("Albert"),new Archer("Artur"), new Viking("Alex"), new Viking("Aston"), new Archer("Ivan")});
        Squad squad2 = new Squad("Squad2",new Warrior[] {new Viking("Bob"),new Archer("Roman"), new Archer("Tom"), new Viking("John"), new Archer("Jerry")});
        for (int i = 0; i < squad1.warriors.length; i++) {
            squad1.warriors[i].setSquatName("Squad1");
            squad2.warriors[i].setSquatName("Squad2");
        }
        DateHelper dateHelper = new DateHelper();
        System.out.println("Start battle: " + dateHelper.getFormattedStartData() + "\n");
        int k = 1;
        while ((squad1.hasAliveWarriors()) || (squad2.hasAliveWarriors())) {
            war1 = squad1.getRandomWarrior();
            System.out.println("War1 " + war1.toString());
            war2 = squad2.getRandomWarrior();
            System.out.println("War2 " + war2.toString());
            if (k % 2 != 0) {
                war2.takeDamage(war1.attack());
                System.out.println("War1 attacks War2");
                if (!war2.isAlive()) {
                    System.out.println(war2.toString() + " died");
                }
            }
            else {
                war1.takeDamage(war2.attack());
                System.out.println("War2 attacks War1");
                if (!war1.isAlive()) {
                    System.out.println(war1.toString() + " died");
                }
            }
            k++;
            dateHelper.skipTime();
            if (!squad1.hasAliveWarriors()) {
                System.out.println("\n" + squad2.toString() + " won");
                System.out.print("Final: " + dateHelper.getFormattedFinalData());
                break;
            }

            if (!squad2.hasAliveWarriors()) {
                System.out.println("\n" + squad1.toString() + " won");
                System.out.print("Final: " + dateHelper.getFormattedFinalData());
                break;
            }
        }
        System.out.println("\n" + "Duration: " + dateHelper.getFormattedDiff());

    }
}
