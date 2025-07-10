import java.util.Scanner;

public class Character {
    public String name;
    public int Strength;
    public int Defense;
    public int Health = 100;
    public int Special = 50;

    public charGen {
        Scanner scanner = new Scanner(System.in);
        String confirm = "No";

        do {
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println(name + " correct? (Yes/No)");

            confirm = scanner.nextLine().trim();

            if (confirm.equalsIgnoreCase("yes")){
                break;
            } else if (confirm.equalsIgnoreCase("no")) {
                continue;
            } else {
                System.out.println("Please enter a valid input (Yes/No)");
                confirm = "No";
            }
        } while (confirm.equalsIgnoreCase("no"));

        do {
            int allocation = 100;
            System.out.println("Allocate your Stats! Strength increases your damage, Defense increases your resistance to damage!");

        }
    }
}
