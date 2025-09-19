package Cw_CMO_cz1.Rest;

import java.util.ArrayList;

class Danie {
    private String nazwa;
    private double cena;
    private String kategoria;
    
    public Danie(String nazwa, double cena, String kategoria) {
        if (nazwa == null || nazwa.trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa nie może być pusta");
        }
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od 0");
        }
        
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
    }
    
    public String getNazwa() { return nazwa; }
    public double getCena() { return cena; }
    public String getKategoria() { return kategoria; }
    
    @Override
    public String toString() {
        return nazwa + " - " + String.format("%.2f", cena) + " zł (" + kategoria + ")";
    }
}

class MenuRestauracji {
    private ArrayList<Danie> dania;
    
    public MenuRestauracji() {
        dania = new ArrayList<>();
    }
    
    public void dodajDanie(Danie d) {
        dania.add(d);
    }
    
    public ArrayList<Danie> daniaZKategorii(String kategoria) {
        ArrayList<Danie> wynik = new ArrayList<>();
        for (Danie d : dania) {
            if (d.getKategoria().equalsIgnoreCase(kategoria)) {
                wynik.add(d);
            }
        }
        return wynik;
    }
    
    public Danie najdrozszeDanie() {
        if (dania.isEmpty()) {
            return null;
        }
        
        Danie najdrozsze = dania.get(0);
        for (Danie d : dania) {
            if (d.getCena() > najdrozsze.getCena()) {
                najdrozsze = d;
            }
        }
        return najdrozsze;
    }
    
    public ArrayList<Danie> wyszukajPoFragmente(String fraza) {
        ArrayList<Danie> wynik = new ArrayList<>();
        String frazaLower = fraza.toLowerCase();
        
        for (Danie d : dania) {
            if (d.getNazwa().toLowerCase().contains(frazaLower)) {
                wynik.add(d);
            }
        }
        return wynik;
    }
}