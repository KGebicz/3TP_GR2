package Cw_CMO_cz1.Wyp_film;
import java.util.ArrayList;

class Film {
    private String tytul;
    private String gatunek;
    private boolean wypozyczony;
    
    public Film(String tytul, String gatunek) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.wypozyczony = false;
    }
    
    public String getTytul() { return tytul; }
    public String getGatunek() { return gatunek; }
    public boolean isWypozyczony() { return wypozyczony; }
    
    public void wypozycz() {
        if (wypozyczony) {
            throw new IllegalStateException("Film jest już wypożyczony");
        }
        wypozyczony = true;
    }
    
    public void oddaj() {
        if (!wypozyczony) {
            throw new IllegalStateException("Film nie był wypożyczony");
        }
        wypozyczony = false;
    }
    
    public String status() {
        return wypozyczony ? "wypożyczony" : "dostępny";
    }
    
    @Override
    public String toString() {
        return tytul + " - " + gatunek + " (" + status() + ")";
    }
}

class Wypozyczalnia {
    private ArrayList<Film> filmy;
    
    public Wypozyczalnia() {
        filmy = new ArrayList<>();
    }
    
    public void dodajFilm(Film f) {
        filmy.add(f);
    }
    
    private Film znajdzFilm(String tytul) {
        for (Film f : filmy) {
            if (f.getTytul().equals(tytul)) {
                return f;
            }
        }
        return null;
    }
    
    public void wypozyczFilm(String tytul) {
        Film f = znajdzFilm(tytul);
        if (f == null) {
            throw new IllegalArgumentException("Film nie znaleziony");
        }
        f.wypozycz();
    }
    
    public void oddajFilm(String tytul) {
        Film f = znajdzFilm(tytul);
        if (f == null) {
            throw new IllegalArgumentException("Film nie znaleziony");
        }
        f.oddaj();
    }
    
    public ArrayList<Film> filmyWGatunku(String gatunek) {
        ArrayList<Film> wynik = new ArrayList<>();
        for (Film f : filmy) {
            if (f.getGatunek().equalsIgnoreCase(gatunek)) {
                wynik.add(f);
            }
        }
        return wynik;
    }
    
    public ArrayList<Film> listaDostepnych() {
        ArrayList<Film> dostepne = new ArrayList<>();
        for (Film f : filmy) {
            if (!f.isWypozyczony()) {
                dostepne.add(f);
            }
        }
        return dostepne;
    }
}
