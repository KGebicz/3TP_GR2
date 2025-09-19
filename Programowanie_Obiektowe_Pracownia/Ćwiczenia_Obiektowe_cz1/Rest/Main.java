package Cw_CMO_cz1.Rest;

public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie dań
            Danie d1 = new Danie("Pizza Margherita", 30, "danie główne");
            Danie d2 = new Danie("Tiramisu", 15, "deser");
            Danie d3 = new Danie("Bruschetta", 12, "przystawka");
            Danie d4 = new Danie("Pizza Pepperoni", 35, "danie główne");
            Danie d5 = new Danie("Sałatka Cezar", 18, "przystawka");
            
            // Tworzenie menu
            MenuRestauracji menu = new MenuRestauracji();
            
            // Dodawanie dań
            menu.dodajDanie(d1);
            menu.dodajDanie(d2);
            menu.dodajDanie(d3);
            menu.dodajDanie(d4);
            menu.dodajDanie(d5);
            
            // Dania z kategorii
            System.out.println("Dania główne:");
            for (Danie d : menu.daniaZKategorii("danie główne")) {
                System.out.println(d);
            }
            
            // Najdroższe danie
            Danie najdrozsze = menu.najdrozszeDanie();
            System.out.println("\nNajdroższe danie: " + najdrozsze);
            
            // Wyszukiwanie po fragmencie
            System.out.println("\nDania zawierające 'Pizza':");
            for (Danie d : menu.wyszukajPoFragmente("Pizza")) {
                System.out.println(d);
            }
            
            System.out.println("\nDania zawierające 'zza':");
            for (Danie d : menu.wyszukajPoFragmente("zza")) {
                System.out.println(d);
            }
            
            System.out.println("\nDania zawierające 'sa':");
            for (Danie d : menu.wyszukajPoFragmente("sa")) {
                System.out.println(d);
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}