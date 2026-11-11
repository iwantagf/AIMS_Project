package com.hust.kstn.models;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = this.nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = this.nbDigitalVideoDiscs++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public float getCost() {
        return this.cost;
    }

    public String getCategory() {
        return this.category;
    }
    
    public int getId() {
        return this.id;
    }

    public void getInfo() {
        System.out.println("===========" + this.title + "===========");
        System.out.println("Category: " + this.category);
        System.out.println("Director: " + this.director);
        System.out.println("Length: " + this.length);
        System.out.println("Price: " + this.cost);
    }
}