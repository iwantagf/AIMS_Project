package com.hust.kstn.test;
import com.hust.kstn.models.Cart;
import com.hust.kstn.models.DigitalVideoDisc;

public class CartTest {
    public static void main(String args[]) {
        Cart cart = new Cart();

        DigitalVideoDisc ManOfSteel = new DigitalVideoDisc("Man of Steel", "Sci-fi", "Unknown", 180, 50.0f);
        DigitalVideoDisc Batman = new DigitalVideoDisc("Batman", "Action", "Unknown", 120, 36.0f);
        DigitalVideoDisc FiftyDaysToLove = new DigitalVideoDisc("Fifty Days To Love", "Rom-com", "Unknown", 140, 40.0f);
        DigitalVideoDisc SpiderManNWH = new DigitalVideoDisc("Spider Man No Way Home", "Sci-fi, Action, Romance", "Unknown", 150, 50.0f);
        DigitalVideoDisc CuaLaiVoBau = new DigitalVideoDisc("Cua lai vo bau", "Bullshit Vietnamese Film, Romance", "Unknown", 100, -30.0f);

        cart.addDVD(ManOfSteel);
        cart.addDVD(Batman);
        cart.addDVD(FiftyDaysToLove);
        cart.addDVD(SpiderManNWH);
        cart.addDVD(CuaLaiVoBau);

        cart.viewCartDetail();
        System.out.print("\n\n\n\n");
        System.out.println("Test Searching");
        cart.searchDVD("Man of Steel", 1)[0].getInfo();
    }
}
