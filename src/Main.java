import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Animal {
    private String name;
    private String type;
    private int birthYear;
    private HashMap<String, Boolean> commands;

    public Animal(String name, String type, int birthYear) {
        this.name = name;
        this.type = type;
        this.birthYear = birthYear;
        this.commands = new HashMap<>();
        this.commands.put("sit", false);
        this.commands.put("lie down", false);
        this.commands.put("serve", false);
        this.commands.put("speak", false);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public HashMap<String, Boolean> getCommands() {
        return commands;
    }

    public void teachCommand(String command) {
        if (!commands.containsKey(command)) {
            commands.put(command, false);
        }
    }

    public void displayCommands() {
        for (String command : commands.keySet()) {
            System.out.println(command);
        }
    }
}

public class Main {
    private static ArrayList<Animal> registry = new ArrayList<>();
    private static int totalAnimals = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice != 6) {
            System.out.println("1. Add new animal");
            System.out.println("2. Teach command to animal");
            System.out.println("3. Display animals by birth year");
            System.out.println("4. Display animal commands");
            System.out.println("5. Display total number of animals");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    teachCommand();
                    break;
                case 3:
                    displayAnimalsByBirthYear();
                    break;
                case 4:
                    displayCommands();
                    break;
                case 5:
                    displayTotalAnimals();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal type: ");
        String type = scanner.nextLine();
        System.out.print("Enter animal birth year: ");
        int birthYear = scanner.nextInt();

        Animal animal = new Animal(name, type, birthYear);
        registry.add(animal);
        totalAnimals++;
    }

    private static void teachCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();

        Animal animal = findAnimal(name);
        if (animal != null) {
            System.out.print("Enter command to teach: ");
            String command = scanner.nextLine();
            animal.teachCommand(command);
            System.out.println("Command '" + command + "' has been taught to " + animal.getName());
        } else {
            System.out.println("Animal not found in registry.");
        }
    }

    private static void displayAnimalsByBirthYear() {
        System.out.println("Animals sorted by birth year:");
        registry.sort((a1, a2) -> a1.getBirthYear() - a2.getBirthYear());
        for (Animal animal : registry) {
            System.out.println(animal.getName() + " - " + animal.getBirthYear());
        }
    }

    private static void displayCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();

        Animal animal = findAnimal(name);
        if (animal != null) {
            System.out.println("Commands for " + animal.getName() + ":");
            animal.displayCommands();
        } else {
            System.out.println("Animal not found in registry.");
        }
    }

    private static void displayTotalAnimals() {
        System.out.println("Total number of animals: " + totalAnimals);
    }

    private static Animal findAnimal(String name) {
        for (Animal animal : registry) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}
