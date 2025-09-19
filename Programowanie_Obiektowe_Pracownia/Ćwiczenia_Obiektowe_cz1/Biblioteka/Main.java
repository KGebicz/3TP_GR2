package Cw_CMO_cz1.Biblioteka;

public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie książek
            Ksiazka k1 = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz");
            Ksiazka k2 = new Ksiazka("Lalka", "Bolesław Prus");
            Ksiazka k3 = new Ksiazka("Wesele", "Stanisław Wyspiański");
            
            // Tworzenie biblioteki
            Biblioteka b = new Biblioteka();
            
            // Dodawanie książek
            b.dodajKsiazke(k1);
            b.dodajKsiazke(k2);
            b.dodajKsiazke(k3);
            
            // Wypożyczanie książek
            b.wypozyczKsiazke("Lalka");
            System.out.println("Wypożyczono 'Lalka'");
            
            // Próba ponownego wypożyczenia
            try {
                b.wypozyczKsiazke("Lalka");
            } catch (IllegalStateException e) {
                System.out.println("Błąd wypożyczenia: " + e.getMessage());
            }
            
            // Listy dostępnych i wypożyczonych
            System.out.println("\nDostępne książki:");
            for (Ksiazka k : b.listaDostepnych()) {
                System.out.println(k);
            }
            
            System.out.println("\nWypożyczone książki:");
            for (Ksiazka k : b.listaWypozyczonych()) {
                System.out.println(k);
            }
            
            // Oddawanie książki
            b.oddajKsiazke("Lalka");
            System.out.println("\nOddano 'Lalka'");
            
            System.out.println("\nDostępne po oddaniu:");
            for (Ksiazka k : b.listaDostepnych()) {
                System.out.println(k);
            }
            
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}