package Tab_roz_cw1;
/**
 * Abstrakcyjna klasa bazowa dla wszystkich zwierząt.
 */
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public abstract void makeSound();

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}