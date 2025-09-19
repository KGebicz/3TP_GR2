package Cw_CMO_cz1.Rejestr_stu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rejestr {
    private ArrayList<Student> studenci;
    
    public Rejestr() {
        studenci = new ArrayList<>();
    }
    
    public ArrayList<Student> getStudenci() {
        return studenci;
    }
    
    public void dodajStudenta(Student s) {
        for (Student student : studenci) {
            if (student.getNumerIndeksu() == s.getNumerIndeksu()) {
                throw new IllegalArgumentException("Student o tym numerze indeksu już istnieje");
            }
        }
        studenci.add(s);
    }
    
    public Student znajdzPoIndeksie(int nr) {
        for (Student s : studenci) {
            if (s.getNumerIndeksu() == nr) {
                return s;
            }
        }
        return null;
    }
    
    public Student najlepszyStudent() {
        if (studenci.isEmpty()) {
            return null;
        }
        
        Student najlepszy = studenci.get(0);
        for (Student s : studenci) {
            if (s.srednia() > najlepszy.srednia()) {
                najlepszy = s;
            }
        }
        return najlepszy;
    }
    
    public void posortujPoNazwisku() {
        Collections.sort(studenci, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNazwisko().compareTo(s2.getNazwisko());
            }
        });
    }
}
