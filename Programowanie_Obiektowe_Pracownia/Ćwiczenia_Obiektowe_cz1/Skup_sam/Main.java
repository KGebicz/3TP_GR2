package Cw_CMO_cz1.Skup_sam;

public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie samochodów
            samochod s1 = new samochod("Audi", "A4", 2018, 80000);
            samochod s2 = new samochod("Toyota", "Corolla", 2010, 35000);
            samochod s3 = new samochod("BMW", "X5", 2020, 150000);
            samochod s4 = new samochod("Audi", "A6", 2018, 95000);
            
            // Tworzenie skupu
            skup skup = new skup();
            
            // Dodawanie samochodów
            skup.dodajSamochod(s1);
            skup.dodajSamochod(s2);
            skup.dodajSamochod(s3);
            skup.dodajSamochod(s4);
            
            // Najdroższy samochód
            samochod najdrozszy = skup.najdrozszySamochod();
            System.out.println("Najdroższy samochód: " + najdrozszy);
            
            // Samochody z roku 2018
            System.out.println("\nSamochody z roku 2018:");
            for (samochod s : skup.listaSamochodowZRoku(2018)) {
                System.out.println(s);
            }
            
            // Usuwanie samochodu
            skup.usunSamochod("Toyota", "Corolla");
            System.out.println("\nPo usunięciu Toyoty Corolla:");
            
            // Wyświetlanie wszystkich samochodów (używając gettera zamiast bezpośredniego dostępu)
            for (samochod s : skup.getSamochody()) {
                System.out.println(s);
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}