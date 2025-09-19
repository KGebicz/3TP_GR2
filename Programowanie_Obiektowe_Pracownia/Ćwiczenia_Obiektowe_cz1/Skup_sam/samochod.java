package Cw_CMO_cz1.Skup_sam;
public class samochod {
    private String marka;
    private String model;
    private int rokProdukcji;
    private double cenaZakupu;
    
    public samochod(String marka, String model, int rokProdukcji, double cenaZakupu) {
        if (rokProdukcji <= 1900) {
            throw new IllegalArgumentException("Rok produkcji musi być większy niż 1900");
        }
        if (cenaZakupu <= 0) {
            throw new IllegalArgumentException("Cena zakupu musi być większa od 0");
        }
        
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.cenaZakupu = cenaZakupu;
    }
    
    public String getMarka() { return marka; }
    public String getModel() { return model; }
    public int getRokProdukcji() { return rokProdukcji; }
    public double getCenaZakupu() { return cenaZakupu; }
    
    @Override
    public String toString() {
        return marka + " " + model + " (" + rokProdukcji + ") - " + 
               String.format("%.2f", cenaZakupu) + " zł";
    }
}