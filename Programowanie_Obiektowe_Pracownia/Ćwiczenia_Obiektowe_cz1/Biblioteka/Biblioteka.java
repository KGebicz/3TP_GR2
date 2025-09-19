package Cw_CMO_cz1.Biblioteka;

import java.util.ArrayList;

class Ksiazka {
    private String tytul;
    private String autor;
    private boolean wypozyczona;
    
    public Ksiazka(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
        this.wypozyczona = false;
    }
    
    public String getTytul() { return tytul; }
    public String getAutor() { return autor; }
    public boolean isWypozyczona() { return wypozyczona; }
    
    public void wypozycz() {
        if (wypozyczona) {
            throw new IllegalStateException("Książka jest już wypożyczona");
        }
        wypozyczona = true;
    }
    
    public void oddaj() {
        if (!wypozyczona) {
            throw new IllegalStateException("Książka nie była wypożyczona");
        }
        wypozyczona = false;
    }
    
    public String status() {
        return wypozyczona ? "wypożyczona" : "dostępna";
    }
    
    @Override
    public String toString() {
        return tytul + " - " + autor + " (" + status() + ")";
    }
}

class Biblioteka {
    private ArrayList<Ksiazka> ksiazki;
    
    public Biblioteka() {
        ksiazki = new ArrayList<>();
    }
    
    public void dodajKsiazke(Ksiazka k) {
        ksiazki.add(k);
    }
    
    private Ksiazka znajdzKsiazke(String tytul) {
        for (Ksiazka k : ksiazki) {
            if (k.getTytul().equals(tytul)) {
                return k;
            }
        }
        return null;
    }
    
    public void wypozyczKsiazke(String tytul) {
        Ksiazka k = znajdzKsiazke(tytul);
        if (k == null) {
            throw new IllegalArgumentException("Książka nie znaleziona");
        }
        k.wypozycz();
    }
    
    public void oddajKsiazke(String tytul) {
        Ksiazka k = znajdzKsiazke(tytul);
        if (k == null) {
            throw new IllegalArgumentException("Książka nie znaleziona");
        }
        k.oddaj();
    }
    
    public ArrayList<Ksiazka> listaDostepnych() {
        ArrayList<Ksiazka> dostepne = new ArrayList<>();
        for (Ksiazka k : ksiazki) {
            if (!k.isWypozyczona()) {
                dostepne.add(k);
            }
        }
        return dostepne;
    }
    
    public ArrayList<Ksiazka> listaWypozyczonych() {
        ArrayList<Ksiazka> wypozyczone = new ArrayList<>();
        for (Ksiazka k : ksiazki) {
            if (k.isWypozyczona()) {
                wypozyczone.add(k);
            }
        }
        return wypozyczone;
    }
}