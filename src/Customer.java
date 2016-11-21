import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by boun on 11/17/16.
 */

public class Customer {
    String name;
    String newAccount;
    String choice;

    HashMap<String, Double> client = new HashMap<String, Double>();

    public void chooseName() throws Exception {
        client.put("George", 1000.0);
        client.put("Wayne", 1200.0);
        client.put("Lucy", 1500.0);
        client.put("Boun", 2000.0);

        while(true) {
            System.out.println("What is your name?");
            name = ATM.scanner.nextLine();
            if (name.isEmpty()) {
                throw new Exception("Name Not Entered!");
            } else if (client.containsKey(name)) {
                System.out.println("Welcome, " + name + ".");

                this.chooseChoice();

            } else {
                System.out.println("You don't have an account.");

                this.chooseNewAccount();
                this.chooseChoice();

            }
        }
    }

    public void chooseNewAccount() throws Exception {

        System.out.println();
        System.out.println("Please choose from options:");
        System.out.println();
        System.out.println("1. Create An Account");
        System.out.println("2. Cancel");
        System.out.println();
        System.out.println("Enter Your Numeric Choice: ");


        newAccount = ATM.scanner.nextLine();

        if (newAccount.equalsIgnoreCase("1")) {
            System.out.println(name + " , Your account has been created");

            client.put(name, 100.0);

            this.chooseChoice();

        } else {
            System.out.println("Please consider us in the future!");
        }
    }

    public void chooseChoice() throws Exception {
        boolean selection = true;

        while (selection) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("1. Check Balance ");
            System.out.println("2. Withdrawal ");
            System.out.println("3. Cancel ");
            System.out.println("4. Remove Account ");
            System.out.println();
            System.out.println("Enter Your Numeric Choice: ");

            choice = ATM.scanner.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Your balance is $" + client.get(name));
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.println("How much do you want to withdrawal?");
                choice = ATM.scanner.nextLine();
                if (Double.parseDouble(choice) > client.get(name)) {
                    throw new Exception("Insufficient Funds");
                }

                double funds = client.get(name) - Double.parseDouble(choice);
                client.put(name, funds);

                System.out.println("Your remaining funds is" + " $" + funds);
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.println("Your account has been removed.");

                client.remove(name);

                this.chooseName();

            }

            else {
                System.out.println("Thank you and please come again!");
                this.chooseName();
                selection = false;
            }
        }
    }


}