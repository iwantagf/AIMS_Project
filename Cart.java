import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Cart {
    private static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc[] items = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (this.qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is almost full!");
            return;
        }

        items[this.qtyOrdered] = dvd;
        this.qtyOrdered++;
        System.out.println("Add to cart successfully!");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int index = -1;

        for (int i = this.qtyOrdered - 1; i >= 0; i--) {
            if (this.items[i].equals(dvd)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("No matched disc found");
            return;
        }

        for (int i = index; i < this.qtyOrdered - 1; i++) {
            this.items[i] = this.items[i + 1];
        }

        this.qtyOrdered--;
        this.items[this.qtyOrdered] = null;
    }

    public float calculateTotalCost() {
        float ans = 0.0f;

        for (int i = 0; i < this.qtyOrdered; i++) {
            ans += this.items[i].getCost();
        }

        return ans;
    }

    public void viewCartDetail() {
        System.out.println("========================================DISC ON CART========================================");
        for (int i = 0; i < this.qtyOrdered; i++) {
            this.items[i].getInfo(); 
        }
    }

    private void createBill() {
        System.out.println("========================================BILL INFO========================================");
        for (int i = 0; i < this.qtyOrdered; i++) {
            this.items[i].getInfo(); 
        }

        System.out.println("Total Cost: " + this.calculateTotalCost());
    }

    public void placeOrder() {
        System.out.println("Creating Bill.....");
        this.createBill();
        System.out.println("Done Sending Billing Info to Card Association System!");
    }

    public DigitalVideoDisc[] searchDVD(String info) {
        return searchDVD(info, 1);
    }

    public DigitalVideoDisc[] searchDVD(String info, int option) {
        if (option == 1) return this.searchByName(info);
        if (option == 2) return this.searchByCategory(info);
        if (option == 3) {
            try {
                float cost = Float.parseFloat(info);
                return this.searchByCost(cost);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid cost input!");
                return new DigitalVideoDisc[0];
            }
        }
        
        return new DigitalVideoDisc[0];
    }

    private DigitalVideoDisc[] searchByName(String name) {
        ArrayList<DigitalVideoDisc> ans = new ArrayList<>();
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.items[i].getTitle().toLowerCase().contains(name.toLowerCase())) {
                ans.add(this.items[i]);
            }
        }
        return ans.toArray(new DigitalVideoDisc[0]); 
    }

    private DigitalVideoDisc[] searchByCategory(String category) {
        ArrayList<DigitalVideoDisc> ans = new ArrayList<>();
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.items[i].getCategory().equalsIgnoreCase(category)) {
                ans.add(this.items[i]);
            }
        }
        return ans.toArray(new DigitalVideoDisc[0]);
    }

    private DigitalVideoDisc[] searchByCost(float cost) {
        ArrayList<DigitalVideoDisc> ans = new ArrayList<>();
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.items[i].getCost() == cost) {
                ans.add(this.items[i]);
            }
        }
        return ans.toArray(new DigitalVideoDisc[0]);
    }

    // Sort method with 2 options: 1 = byName, 2 = byCost
    
    public void sortDVD(int option) {
        if (this.qtyOrdered == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        if (option == 1) {
            // Sort by Title (A-Z)
            Arrays.sort(this.items, 0, this.qtyOrdered, new Comparator<DigitalVideoDisc>() {
                @Override
                public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
                    return d1.getTitle().compareToIgnoreCase(d2.getTitle());
                }
            });
            System.out.println("Cart sorted by Title.");
        } else if (option == 2) {
            // Sort by Cost (Ascending)
            Arrays.sort(this.items, 0, this.qtyOrdered, new Comparator<DigitalVideoDisc>() {
                @Override
                public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
                    return Float.compare(d1.getCost(), d2.getCost());
                }
            });
            System.out.println("Cart sorted by Cost.");
        } else {
            System.out.println("Invalid option! Use 1 (byName) or 2 (byCost).");
        }
    }
}