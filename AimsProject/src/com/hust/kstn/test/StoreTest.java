package com.hust.kstn.test;

import com.hust.kstn.models.Store;
import com.hust.kstn.models.Cart;
import com.hust.kstn.models.DigitalVideoDisc;

public class StoreTest {
    public static void main(String args[]) {
        Store myStore = new Store();

        DigitalVideoDisc ManOfSteel = new DigitalVideoDisc("Man of Steel", "Sci-fi", "Unknown", 180, 50.0f);
        DigitalVideoDisc Batman = new DigitalVideoDisc("Batman", "Action", "Unknown", 120, 36.0f);
        DigitalVideoDisc FiftyDaysToLove = new DigitalVideoDisc("Fifty Days To Love", "Rom-com", "Unknown", 140, 40.0f);
        DigitalVideoDisc SpiderManNWH = new DigitalVideoDisc("Spider Man No Way Home", "Sci-fi, Action, Romance", "Unknown", 150, 50.0f);
        DigitalVideoDisc CuaLaiVoBau = new DigitalVideoDisc("Cua lai vo bau", "Bullshit Vietnamese Film, Romance", "Unknown", 100, -30.0f);

        System.out.println("===== TEST 1: STORE CAPACITY (100 ITEMS MAX) =====");
        for (int i = 0; i < 102; i++) {
            System.out.println("Adding disc " + (i + 1));
            switch (i % 5) {
                case 0 -> myStore.addDVD(ManOfSteel);
                case 1 -> myStore.addDVD(Batman);
                case 2 -> myStore.addDVD(FiftyDaysToLove);
                case 3 -> myStore.addDVD(SpiderManNWH);
                case 4 -> myStore.addDVD(CuaLaiVoBau);
            }
        }

        myStore.printItems();

        System.out.println("\n===== TEST 2: REMOVE FROM EMPTY STORE =====");
        Store emptyStore = new Store();
        emptyStore.removeDVD(ManOfSteel);
        emptyStore.printItems();

        System.out.println("\n===== TEST 3: REMOVE NON-EXISTING ITEM =====");
        Store anotherStore = new Store();
        anotherStore.addDVD(ManOfSteel);
        anotherStore.addDVD(Batman);
        anotherStore.printItems();

        System.out.println("Trying to remove disc that is not in store (Fifty Days To Love)");
        anotherStore.removeDVD(FiftyDaysToLove);
        anotherStore.printItems();
    }
}