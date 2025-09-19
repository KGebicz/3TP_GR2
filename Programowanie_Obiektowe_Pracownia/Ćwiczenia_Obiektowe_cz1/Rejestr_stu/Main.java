package Cw_CMO_cz1.Rejestr_stu;

public class Main {
    public static void main(String[] args) {
        try {
            // Tworzenie studentów
            Student s1 = new Student("Jan", "Kowalski", 1001);
            Student s2 = new Student("Anna", "Nowak", 1002);
            Student s3 = new Student("Piotr", "Zalewski", 1003);
            
            // Dodawanie ocen
            s1.dodajOcene(5.0);
            s1.dodajOcene(4.0);
            s1.dodajOcene(4.5);
            
            s2.dodajOcene(3.0);
            s2.dodajOcene(4.5);
            s2.dodajOcene(5.0);
            
            s3.dodajOcene(2.5);
            s3.dodajOcene(3.0);
            s3.dodajOcene(3.5);
            
            // Tworzenie rejestru
            Rejestr r = new Rejestr();
            
            // Dodawanie studentów do rejestru
            r.dodajStudenta(s1);
            r.dodajStudenta(s2);
            r.dodajStudenta(s3);
            
            // Wyszukiwanie studenta po indeksie
            Student znaleziony = r.znajdzPoIndeksie(1002);
            if (znaleziony != null) {
                System.out.println("Znaleziono studenta: " + znaleziony);
            }
            
            // Najlepszy student
            Student najlepszy = r.najlepszyStudent();
            System.out.println("Najlepszy student: " + najlepszy);
            
            // Sortowanie po nazwisku
            System.out.println("\nPrzed sortowaniem:");
            for (Student student : r.getStudenci()) {
                System.out.println(student);
            }
            
            r.posortujPoNazwisku();
            
            System.out.println("\nPo sortowaniu po nazwisku:");
            for (Student student : r.getStudenci()) {
                System.out.println(student);
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}