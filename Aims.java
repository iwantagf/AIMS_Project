import java.util.Scanner;

class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc ManOfSteel = new DigitalVideoDisc("Man of Steel", "Sci-fi", "Unknown", 180, 50.0f);
        DigitalVideoDisc Batman = new DigitalVideoDisc("Batman", "Action", "Unknown", 120, 36.0f);
        DigitalVideoDisc FiftyDaysToLove = new DigitalVideoDisc("Fifty Days To Love", "Rom-com", "Unknown", 140, 40.0f);
        DigitalVideoDisc SpiderManNWH = new DigitalVideoDisc("Spider Man No Way Home", "Sci-fi, Action, Romance", "Unknown", 150, 50.0f);
        DigitalVideoDisc CuaLaiVoBau = new DigitalVideoDisc("Cua lai vo bau", "Bullshit Vietnamese Film, Romance", "Unknown", 100, -30.0f);
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        
        String menu = "You can do one of these operations by typing its index to the console then press Enter\n"
                + "1. Add a DVD to cart\n"
                + "2. Remove a DVD from cart\n"
                + "3. Print current cart\n"
                + "4. Sort cart by price\n"
                + "5. Sort cart by title\n"
                + "6. Find an item in cart by its ID\n"
                + "7. Find an item in cart by its title\n"
                + "8. Place an order\n"
                + "9. Show the operations";

        System.out.println(menu);
        
        while (true) {
            int option = sc.nextInt();
            
            if (option == 9) {
                System.out.println(menu);
                continue;
            }
            
            if (option == 1) {
                System.out.println("Choose one of these discs: \n"
                        + "1. Man Of Steel\n"
                        + "2. Batman\n"
                        + "3. Fifty Days To Love\n"
                        + "4. Spider Man No Way Home\n"
                        + "5. Bullshit Vietnamese Film");
                
                int chosenDisc = sc.nextInt();
                
                switch (chosenDisc) {
                    case 1: cart.addDVD(ManOfSteel); break;
                    case 2: cart.addDVD(Batman); break;
                    case 3: cart.addDVD(FiftyDaysToLove); break;
                    case 4: cart.addDVD(SpiderManNWH); break;
                    case 5: cart.addDVD(CuaLaiVoBau); break;
                    default: System.out.println("We haven't had this disc in the list"); break;
                }
                continue;
            }
            
            if (option == 2) {
                System.out.println("Choose one of these discs to remove: \n"
                        + "1. Man Of Steel\n"
                        + "2. Batman\n"
                        + "3. Fifty Days To Love\n"
                        + "4. Spider Man No Way Home\n"
                        + "5. Bullshit Vietnamese Film");
                
                int chosenDisc = sc.nextInt();
                
                switch (chosenDisc) {
                    case 1: cart.removeDVD(ManOfSteel); break;
                    case 2: cart.removeDVD(Batman); break;
                    case 3: cart.removeDVD(FiftyDaysToLove); break;
                    case 4: cart.removeDVD(SpiderManNWH); break;
                    case 5: cart.removeDVD(CuaLaiVoBau); break;
                    default: System.out.println("We haven't had this disc in the list"); break;
                }
                continue;
            }
            
            if (option == 3) {
                // Replaced cart.printItems() with the method from Cart.java
                cart.viewCartDetail();
                continue;
            }
            
            if (option == 4) {
                // Replaced cart.sortCartByPrice() with sortDVD(2) (2 = byCost)
                cart.sortDVD(2);
                continue;
            }
            
            if (option == 5) {
                // Replaced cart.sortCartByTitle() with sortDVD(1) (1 = byName)
                cart.sortDVD(1);
                continue;
            }
            
            if (option == 6) {
                System.out.println("Enter an ID: ");
                String ID = String.valueOf(sc.nextInt());
                // Note: Cart.java currently does not have a searchByID method.
                // You will need to add an ID field to DigitalVideoDisc and a searchByID method to Cart to make this work.
                System.out.println("Search by ID is not yet implemented in Cart.java!");
                continue;
            }
            
            if (option == 7) {
                System.out.println("Enter a title: ");
                sc.nextLine(); // Consume the leftover newline from nextInt()
                String title = sc.nextLine();
                
                // Uses the overloaded searchDVD method (option 1 = searchByName)
                DigitalVideoDisc[] foundItems = cart.searchDVD(title, 1);
                
                if (foundItems.length == 0) {
                    System.out.println("No matching DVD found with title: " + title);
                } else {
                    System.out.println("Found " + foundItems.length + " result(s):");
                    for (DigitalVideoDisc dvd : foundItems) {
                        dvd.getInfo();
                    }
                }
                continue;
            }
            
            if (option == 8) {
                cart.placeOrder();
                break;
            }
        }
        
        sc.close();
    }
}