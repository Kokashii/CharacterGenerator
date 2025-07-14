import java.util.Scanner;

public class Character {
    public String name;
    public int Strength;
    public int Defense;
    public int Health = 200;
    public int Special = 50;
    public int Allocation = 50;
    String confirm = "No";

    public Scanner scanner = new Scanner(System.in);
//Currently program ignores confirm prompt and automatically exits after displayStats. Need to reconfigure how to loop
    //Consider changing looping from while?
    public void charGen() {
        do {
            getName();
            getStrength();
            getDefense();
            getSpecial();
            displayStats();

            System.out.println("Is this information correct? (Yes/No)");
            confirm = scanner.nextLine().trim();

            if (confirm.equalsIgnoreCase("yes")) {
                break;
            } else if (confirm.equalsIgnoreCase("no")) {
                continue;
            } else {
                System.out.println("Please enter a valid input (Yes/No)");
            }

        } while (confirm.equalsIgnoreCase("no"));

    }

    public void getName() {
            System.out.println("What is your name?");
            name = scanner.nextLine();
    }

    public void getStrength() {
        do {
            System.out.println("First choose your Strength. Enter a value between 1-50 for your Strength.");
            Strength = scanner.nextInt();

            if (Strength >= 1 && Strength <= 50) {
                Allocation = 50 - Strength;
            } else {
                System.out.println("Please enter a valid input.");
            }
        } while (Allocation == 50);
    }
//Change while condition due to input not cycling to Special. As is it keeps allowing you to increase your defense but never go elsewhere.
    public void getDefense() {

        if (Allocation > 0) {
            do {
                System.out.println("Now choose your Defense. Remaining points to allocate: " + Allocation);
                Defense = scanner.nextInt();

                if (Defense <= Allocation) {
                    Allocation = Allocation - Defense;
                } else {
                    System.out.println("Please enter a valid input.");
                }
            } while (Allocation > 0);
        } else {
            System.out.println("You've utilized all stat allocation points.");
        }
    }

    public void getSpecial() {
        if (Allocation > 0) {
            do {
                System.out.println("Now choose your Special. Remaining points to allocate: " + Allocation);
                Special = 50 + scanner.nextInt();

                if (Special - 50 <= Allocation ) {
                    Allocation = 0;
                } else {
                    System.out.println("You've utilized all stat allocation points.");
                }
            } while (Allocation > 0);
        } else {
            System.out.println("You've utilized all stat allocation points.");
        }
    }

        public void displayStats () {
            System.out.println("Current Stats:");
            System.out.println("Name: " + name);
            System.out.println("Strength: " + Strength);
            System.out.println("Defense: " + Defense);
            System.out.println("Special: " + Special);
        }

    }