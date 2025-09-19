package Cw_CMO_cz1.Magazyn;

import java.util.ArrayList;

class Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;
    
    public Produkt(String nazwa, double cena, int ilosc) {
        if (nazwa.isEmpty()|| nazwa == null) {
            throw new IllegalArgumentException("Nazwa nie może być pusta ani null");
        }
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od 0");
        }
        if (ilosc < 0) {
            throw new IllegalArgumentException("Ilość nie może być ujemna");
        }
        
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }
    
    public String getNazwa() { return nazwa; }
    public double getCena() { return cena; }
    public int getIlosc() { return ilosc; }
    
    public void dodaj(int sztuk) {
        if (sztuk <= 0) {
            throw new IllegalArgumentException("Liczba sztuk musi być większa od 0");
        }
        this.ilosc += sztuk;
    }
    
    public void sprzedaj(int sztuk) {
        if (sztuk <= 0) {
            throw new IllegalArgumentException("Liczba sztuk musi być większa od 0");
        }
        if (sztuk > ilosc) {
            throw new IllegalArgumentException("Nie można sprzedać więcej niż dostępna ilość");
        }
        this.ilosc -= sztuk;
    }
}

class Magazyn {
    private ArrayList<Produkt> produkty;
    
    public Magazyn() {
        produkty = new ArrayList<>();
    }
    
    public void dodajProdukt(Produkt p) {
        produkty.add(p);
    }
    
    public Produkt znajdzProdukt(String nazwa) {
        for (Produkt p : produkty) {
            if (p.getNazwa().equals(nazwa)) {
                return p;
            }
        }
        return null;
    }
    
    public double wartoscMagazynu() {
        double suma = 0;
        for (Produkt p : produkty) {
            suma += p.getCena() * p.getIlosc();
        }
        return suma;
    }
}