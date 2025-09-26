package Tab_roz_cw1;

public class Lion extends Animal implements Feedable {
    private double maneLength;

    public Lion(String name, int age, double maneLength) {
        super(name, age);
        this.maneLength = maneLength;
    }

    @Override
    public void makeSound() {
        System.out.println("Lion roars: ROAR!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding meat to lion");
    }

    @Override
    public String getFoodType() {
        return "Meat";
    }
}
