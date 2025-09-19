package Cw_CMO_cz1.Rejestr_stu;
import java.util.ArrayList;

public class Student {
    private String imie;
    private String nazwisko;
    private final int numerIndeksu;
    private ArrayList<Double> oceny;
    
    public Student(String imie, String nazwisko, int numerIndeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerIndeksu = numerIndeksu;
        this.oceny = new ArrayList<>();
    }
    
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public int getNumerIndeksu() { return numerIndeksu; }
    
    public void dodajOcene(double ocena) {
        if (ocena < 2.0 || ocena > 5.0) {
            throw new IllegalArgumentException("Ocena musi być w zakresie 2.0 - 5.0");
        }
        oceny.add(ocena);
    }
    
    public double srednia() {
        if (oceny.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (double ocena : oceny) {
            suma += ocena;
        }
        return suma / oceny.size();
    }
    
    @Override
    public String toString() {
        return imie + " " + nazwisko + " (indeks: " + numerIndeksu + 
               "), średnia: " + String.format("%.2f", srednia());
    }
}