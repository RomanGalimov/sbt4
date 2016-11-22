package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Battle {

    public static void main(String[] args) {
        Squad squad1 = new Squad(5, new Warrior[]{new Viking("Albert"), new Archer("Artur"), new Viking("Alex"), new Viking("Aston"), new Archer("Ivan")});
        Squad squad2 = new Squad(5, new Warrior[]{new Viking("Bob"), new Archer("Roman"), new Archer("Tom"), new Viking("John"), new Archer("Jerry")});
        new Battle2().battle(squad1, squad2);
    }
}
