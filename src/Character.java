import java.util.Scanner;

public class Character {
    public String name;
    public int Strength;
    public int Defense;
    public int Health = 100;
    public int Special = 50;
    public int Allocation = 50;
    String confirm = "No";

    public Scanner scanner = new Scanner(System.in);

    public void charGen() {

        do {
            System.out.println("What is your name?");
            name = scanner.nextLine();
            System.out.println(name + " correct? (Yes/No)");

            confirm = scanner.nextLine().trim();

            if (confirm.equalsIgnoreCase("yes")) {
                break;
            } else if (confirm.equalsIgnoreCase("no")) {
                continue;
            } else {
                System.out.println("Please enter a valid input (Yes/No)");
                confirm = "No";
            }
        } while (confirm.equalsIgnoreCase("no"));

        public void getStrength () {
            System.out.println("First choose your Strength. Enter a value between 1-50 for your Strength.");
            Strength = scanner.nextInt();

            if (Strength >= 50 || Strength <= 0) {
                System.out.println("Please enter a valid input.");
                Allocation = 50;
            } else if (Strength >= 1 && Strength <= 50) {
                Allocation = 50 - Strength;
            }
        }

        public void getDefense () {

        }

        void displayStats () {
            System.out.println("Current Stats:");
            System.out.println("Name " + name);
            System.out.println("Strength " + Strength);
            System.out.println("Defense " + Defense);
        }

    }