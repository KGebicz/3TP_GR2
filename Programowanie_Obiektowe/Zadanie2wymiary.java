import java.util.Random;
import java.util.Scanner;

public class Zadanie2wymiary {
    // -----------------------------------
    // 1. Pobieranie danych od użytkownika
    // -----------------------------------
    public static int pobierzLiczbeZestawow() {

        Scanner sc = new Scanner(System.in);
        int liczba;

        System.out.print("Podaj liczbę zestawów do wylosowania: ");

        // Pętla trwa aż użytkownik poda liczbę dodatnią
        while (true) {
            liczba = sc.nextInt();

            if (liczba > 0) {
                return liczba;
            }

            System.out.print("Błędna wartość! Podaj liczbę dodatnią: ");
        }
    }

    // -----------------------------------
    // 2. Generowanie wielu zestawów liczb
    // -----------------------------------
    public static int[][] generujZestawy(int liczbaZestawow) {

        // Tworzymy tablicę 2D: każdy wiersz to jeden zestaw 4 liczb
        int[][] tablica = new int[liczbaZestawow][4];

        // Wypełniamy każdy wiersz nowo wylosowanym zestawem
        for (int i = 0; i < liczbaZestawow; i++) {
            tablica[i] = losujZestaw();
        }

        return tablica;
    }

    // -----------------------------------
    // Generowanie jednego zestawu 4 liczb
    // -----------------------------------
    public static int[] losujZestaw() {

        Random rand = new Random();
        int[] zestaw = new int[4]; // zestaw ma 4 liczby
        int index = 0;

        // Losujemy liczby dopóki zestaw nie jest pełny
        while (index < 4) {

            // Losowanie liczby z zakresu -15 do 15
            int liczba = rand.nextInt(31) - 15;

            // Sprawdzamy, czy liczba już była w zestawie
            if (!czyZawiera(zestaw, liczba, index)) {

                // Jeśli nie ma duplikatu — zapisujemy ją
                zestaw[index] = liczba;
                index++;
            }
        }

        return zestaw;
    }

    // -----------------------------------
    // Sprawdza, czy liczba już istnieje w zestawie
    // -----------------------------------
    public static boolean czyZawiera(int[] tabela, int liczba, int zakres) {

        // Przeglądamy tylko część tablicy, która już została wypełniona
        for (int i = 0; i < zakres; i++) {
            if (tabela[i] == liczba) {
                return true; // znaleziono duplikat
            }
        }

        return false; // liczba NIE występuje — można dodać
    }

    // -----------------------------------
    // 3. Wyświetlanie zestawów
    // -----------------------------------
    public static void wyswietlZestawy(int[][] zestawy) {

        for (int i = 0; i < zestawy.length; i++) {

            // Nagłówek zestawu
            System.out.print("Zestaw " + (i + 1) + ": ");

            // Wyświetlanie 4 liczb z zestawu
            for (int j = 0; j < 4; j++) {
                System.out.print(zestawy[i][j]);

                // Dodaj przecinek po każdej liczbie oprócz ostatniej
                if (j < 3) {
                    System.out.print(", ");
                }
            }

            System.out.println(); // przejście do nowej linii
        }
    }

    // -----------------------------------
    // 4. Analiza statystyczna liczb
    // -----------------------------------
    public static void analizujZestawy(int[][] zestawy) {

        // Tablica do zliczania liczby wystąpień
        // Indeks 0 = -15, indeks 30 = +15
        int[] wystapienia = new int[31];

        int dodatnie = 0;
        int ujemne = 0;
        int zera = 0;

        // Przechodzimy przez wszystkie liczby we wszystkich zestawach
        for (int[] zestaw : zestawy) {
            for (int liczba : zestaw) {

                // Zliczanie wystąpień
                int index = liczba + 15; 
                wystapienia[index]++;

                // Dodatnie / ujemne / zero
                if (liczba > 0) {
                    dodatnie++;
                } else if (liczba < 0) {
                    ujemne++;
                } else {
                    zera++;
                }
            }
        }

        // Wyświetlanie wyników
        System.out.println("Wystąpienia liczb od -15 do 15:");

        for (int i = 0; i < wystapienia.length; i++) {

            int liczba = i - 15;

            // Wyświetlamy: liczba -> ile razy wystąpiła
            System.out.println(liczba + " -> " + wystapienia[i] + " razy");
        }

        // Podsumowanie końcowe
        System.out.println("\nPodsumowanie:");
        System.out.println("Liczb dodatnich: " + dodatnie);
        System.out.println("Liczb ujemnych: " + ujemne);
        System.out.println("Zer: " + zera);
    }
    public static void main(String[] args) {

        // Pobieramy od użytkownika liczbę zestawów
        int liczbaZestawow = pobierzLiczbeZestawow();

        // Tworzymy i wypełniamy tablicę zestawów
        int[][] zestawy = generujZestawy(liczbaZestawow);
        
        // Wyświetlamy wszystkie wygenerowane zestawy
        System.out.println("\n--- Wylosowane zestawy ---");
        wyswietlZestawy(zestawy);

        // Analiza statystyczna liczb
        System.out.println("\n--- Analiza statystyczna ---");
        analizujZestawy(zestawy);
    }
}