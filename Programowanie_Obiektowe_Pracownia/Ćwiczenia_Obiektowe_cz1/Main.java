package Lekcja3_CW;

public class Main {

    public static void main(String[] args) {
        Uczen u = new Uczen("Jan", "Kowalski");
        u.dodajOcene(5);
        u.dodajOcene(4);
        u.dodajOcene(3);
        u.przedstawSie();

        Uczen bezOcen = new Uczen("Anna", "Nowak");
        bezOcen.przedstawSie();
    }
}