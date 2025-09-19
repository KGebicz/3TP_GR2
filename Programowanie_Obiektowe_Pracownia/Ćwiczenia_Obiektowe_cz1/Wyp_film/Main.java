package Cw_CMO_cz1.Wyp_film;


public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie filmów
            Film f1 = new Film("Matrix", "Sci-Fi");
            Film f2 = new Film("Titanic", "Dramat");
            Film f3 = new Film("Shrek", "Animacja");
            Film f4 = new Film("Incepcja", "Sci-Fi");
            
            // Tworzenie wypożyczalni
            Wypozyczalnia w = new Wypozyczalnia();
            
            // Dodawanie filmów
            w.dodajFilm(f1);
            w.dodajFilm(f2);
            w.dodajFilm(f3);
            w.dodajFilm(f4);
            
            // Wypożyczanie filmu
            w.wypozyczFilm("Matrix");
            System.out.println("Wypożyczono 'Matrix'");
            
            // Próba ponownego wypożyczenia
            try {
                w.wypozyczFilm("Matrix");
            } catch (IllegalStateException e) {
                System.out.println("Błąd wypożyczenia: " + e.getMessage());
            }
            
            // Filmy w gatunku Sci-Fi
            System.out.println("\nFilmy Sci-Fi:");
            for (Film f : w.filmyWGatunku("Sci-Fi")) {
                System.out.println(f);
            }
            
            // Lista dostępnych filmów
            System.out.println("\nDostępne filmy:");
            for (Film f : w.listaDostepnych()) {
                System.out.println(f);
            }
            
            // Oddawanie filmu
            w.oddajFilm("Matrix");
            System.out.println("\nOddano 'Matrix'");
            
            System.out.println("\nDostępne po oddaniu:");
            for (Film f : w.listaDostepnych()) {
                System.out.println(f);
            }
            
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
