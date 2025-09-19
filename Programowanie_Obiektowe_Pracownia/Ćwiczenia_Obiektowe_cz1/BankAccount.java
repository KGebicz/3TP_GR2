package Lekcja3_CW;

public class BankAccount { // definicja klasy BankAccount (konto bankowe)
    // private String numerKonta;      // numer konta np. "111-222"
    private double saldo;           // aktualne saldo (stan środków na koncie)
    private static int liczbaKont = 0; // statyczne pole: licznik utworzonych kont

    // Konstruktor ustawiający numer konta i saldo początkowe
    public BankAccount(String numerKonta, double saldoPoczatkowe) {
        // this.numerKonta = numerKonta;   // przypisanie numeru konta
        this.saldo = saldoPoczatkowe;   // ustawiamy saldo startowe
        liczbaKont++;                   // zwiększamy licznik kont (dla całej klasy, nie obiektu)
    }

    // Metoda wplaty — dodaje środki do konta
    public void wplac(double kwota) {
        if (kwota > 0) saldo += kwota; // tylko dodatnie kwoty można wpłacać
        else System.out.println("Kwota do wpłaty musi być dodatnia.");
    }

    // Metoda wypłaty — zmniejsza saldo
    public void wyplac(double kwota) {
        if (kwota <= 0) { // sprawdzamy czy kwota jest dodatnia
            System.out.println("Kwota do wypłaty musi być dodatnia.");
        } else if (kwota <= saldo) { // sprawdzamy czy są wystarczające środki
            saldo -= kwota; // odejmujemy od salda
        } else {
            System.out.println("Niewystarczające środki. Saldo: " + saldo);
        }
    }

    // Getter do odczytania salda
    public double getSaldo() {
        return saldo;
    }

    // Getter statyczny — zwraca łączną liczbę utworzonych kont
    public static int getLiczbaKont() {
        return liczbaKont;
    }

    // Główna metoda testowa
    public static void main(String[] args) {
        BankAccount konto1 = new BankAccount("111-222", 1000.0); // pierwsze konto
        BankAccount konto2 = new BankAccount("333-444", 500.0);  // drugie konto
        System.out.println("Liczba kont: " + BankAccount.getLiczbaKont()); // powinno być 2

        konto1.wplac(200);   // wpłacamy 200 → saldo 1200
        konto1.wyplac(500);  // wypłacamy 500 → saldo 700
        System.out.println("Saldo konta1: " + konto1.getSaldo()); // wypisze 700.0

        konto2.wyplac(600); // próba wypłaty większej niż saldo → komunikat o błędzie
    }
}
