package Cw_CMO_cz1.Skup_sam;

import java.util.ArrayList;

public class skup {
    private ArrayList<samochod> samochody;
    
    public skup() {
        samochody = new ArrayList<>();
    }
    
    // Getter dla listy samochodów
    public ArrayList<samochod> getSamochody() {
        return samochody;
    }
    
    public void dodajSamochod(samochod s) {
        samochody.add(s);
    }
    
    public void usunSamochod(String marka, String model) {
        for (int i = 0; i < samochody.size(); i++) {
            samochod s = samochody.get(i);
            if (s.getMarka().equals(marka) && s.getModel().equals(model)) {
                samochody.remove(i);
                return;
            }
        }
    }
    
    public samochod najdrozszySamochod() {
        if (samochody.isEmpty()) {
            return null;
        }
        
        samochod najdrozszy = samochody.get(0);
        for (samochod s : samochody) {
            if (s.getCenaZakupu() > najdrozszy.getCenaZakupu()) {
                najdrozszy = s;
            }
        }
        return najdrozszy;
    }
    
    public ArrayList<samochod> listaSamochodowZRoku(int rok) {
        ArrayList<samochod> wynik = new ArrayList<>();
        for (samochod s : samochody) {
            if (s.getRokProdukcji() == rok) {
                wynik.add(s);
            }
        }
        return wynik;
    }
}