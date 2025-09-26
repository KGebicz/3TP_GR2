package Tab_roz_cw1;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo zoo = new Zoo(5);

        Lion lion = new Lion("Simba", 5, 1.2);
        

        zoo.addAnimal(lion);

        zoo.displayAllAnimals();
        zoo.makeAllSounds();
        zoo.feedAllAnimals();
    }
}