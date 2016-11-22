package com.company;

/**
 * Created by tyuly on 22.11.2016.
 */
public class Battle2 {
    Warrior war1;
    Warrior war2;

    public void battle (Squad squad1, Squad squad2) {
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
