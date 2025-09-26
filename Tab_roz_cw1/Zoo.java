package Tab_roz_cw1;

public class Zoo {
    private Animal[] animals;
    private int count;

    public Zoo(int capacity) {
        animals = new Animal[capacity];
        count = 0;
    }

    public void addAnimal(Animal animal) {
        if (count < animals.length) {
            animals[count++] = animal;
        } else {
            System.out.println("Zoo is full!");
        }
    }

    public void makeAllSounds() {
        for (int i = 0; i < count; i++) {
            animals[i].makeSound();
        }
    }

    public void feedAllAnimals() {
        for (int i = 0; i < count; i++) {
            if (animals[i] instanceof Feedable f) {
                f.feed();
            }
        }
    }

    public void displayAllAnimals() {
        for (int i = 0; i < count; i++) {
            animals[i].displayInfo();
        }
    }
}
