public class Week02 {
    public static void OOPExample(){
        // Basic Class Example
        // Creating objects (instances) of the Dog class
        Dog dog1 = new Dog("Buddy", 3);
        Dog dog2 = new Dog("Max", 5);

        // Using methods and accessing attributes of objects
        dog1.bark();
        dog2.introduce();

        // Inheritance Example
        // Creating objects of the Cat and Kitten classes
        Cat cat = new Cat("Whiskers", 3, "Siamese");
        Kitten kitten = new Kitten("Mittens", 1, "Persian");

        // Using methods of the Cat class
        cat.meow();
        cat.info();

        System.out.println();

        // Using methods of the Kitten class (including inherited methods)
        kitten.meow();
        kitten.info();
        kitten.play();

        System.out.println();

        // Polymorphism Example
        // Creating an array of Cat objects
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Mittens", 6, "Siamese");
        cats[1] = new Kitten("Fluffy", 3, "Persian");
        cats[2] = new Lion("Simba", 6, "Wild");

        // Polymorphic method invocation
        for (Cat c : cats) {
            c.makeSound();
        }

        System.out.println();

        // Polymorphism Overloading Example
        Cat kucing = new Cat("Whiskers", 3, "Siamese");

        // Using the first version of makeSound
        kucing.makeSound();

        // Using the second version of makeSound with function overloading
        kucing.makeSound(3);

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void bark() {
        System.out.println(name + " is barking!");
    }

    public void introduce() {
        System.out.println("I'm " + name + ", a " + age + "-year-old dog.");
    }
}

class Cat {
    private String name;
    private int age;
    private String breed;

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void meow() {
        System.out.println(name + " says: Meow!");
    }

    public void info() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Breed: " + breed);
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public void makeSound(int times) {
        System.out.println(name + " purrs " + times + " times.");
    }

    public String getName(){
        return this.name;
    }
}

class Kitten extends Cat {
    public Kitten(String name, int age, String breed) {
        super(name, age, breed);
    }

    public void play() {
        System.out.println(getName() + " is playing with a ball of yarn.");
    }
}

class Lion extends Cat {
    public Lion(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public void makeSound() {
        System.out.println("Lion " + getName() + " roars loudly!");
    }
}
