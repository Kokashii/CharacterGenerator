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

    public void charGen() {
        do {
            getName();
            getStrength();
            getDefense();
            getSpecial();
            displayStats();

            System.out.println("Is this information correct? (Yes/No)");
            confirm = scanner.nextLine().trim(); //Clears pre-existing empty string from integer prompts
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

    //Getter for player name
    public void getName() {
            System.out.println("What is your name?");
            name = scanner.nextLine();
    }

    //Getter method for Strength stat
    public void getStrength() {
        do {
            System.out.println("First choose your Strength. Enter a value between 1-50 for your Strength.");
            Strength = scanner.nextInt();

            //Logic to control flow correct inputs
            if (Strength >= 1 && Strength <= 50) {
                Allocation = 50 - Strength;
            } else {
                System.out.println("Please enter a valid input.");
            }
        } while (Allocation == 50);
    }
//Get defense for player
    public void getDefense() {

        if (Allocation > 0) {
            do {
                System.out.println("Now choose your Defense. Remaining points to allocate: " + Allocation);
                Defense = scanner.nextInt();

                //Logic to control flow correct inputs
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

    //Get special stat for player
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
            } while (Allocation > 0); //This is to make sure the player inputs a correct response, and doesn't try to cheat the system. Currently running into problem where if they don't allocate remaining amount, it'll continue to ask for this value until allocation is 0.
        } else {
            System.out.println("You've utilized all stat allocation points.");
        }
    }

    //Display final stats
        public void displayStats () {
            System.out.println("Current Stats:");
            System.out.println("Name: " + name);
            System.out.println("Strength: " + Strength);
            System.out.println("Defense: " + Defense);
            System.out.println("Special: " + Special);
        }

    }