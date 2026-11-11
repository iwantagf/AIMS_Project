package com.hust.kstn.models;

import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
    private final int MAX_NUMBER_STORED = 100;
    private int quantityStored = 0;

    public void addDVD(DigitalVideoDisc... discs) {
		if (discs == null || discs.length == 0) {
			return;
		}

		for (DigitalVideoDisc disc : discs) {
			if (disc == null) continue;

			if (this.quantityStored == MAX_NUMBER_STORED) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				System.out.println("Reached maximum number of discs to be stored.");
				return;
			}

			this.itemsInStore.add(disc);
			this.quantityStored++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} //Chép từ bên kia sang nên giữ lại hahaha

			System.out.println("Added " + disc.getTitle() + " successfully!");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (itemsInStore.isEmpty()) {
			System.out.println("There is no discs in store!");
			return;
		}

		if (itemsInStore.remove(disc)) {
			this.quantityStored--;
			System.out.println("Removed " + disc.getTitle() + " successfully");
			return;
		}
		
		System.out.println("Failed to remove " + disc.getTitle());
		
		return;
	}

    public void printItems() {
		System.out.println("============= THE CURRENT STORE =============");

		if (this.itemsInStore.isEmpty()) {
			System.out.println("The store is currently empty.");
			System.out.println("============================================");
			return;
		}

		System.out.println("Total items: " + this.itemsInStore.size());

		for (DigitalVideoDisc disc : itemsInStore) {
			System.out.println("- " + disc.toString());
		}

		System.out.println();
		System.out.println("============================================");
	}
}