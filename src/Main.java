import java.util.Scanner;

public class Main {
    // The Main class that presents a menu to the user with the following options:
    //Residential Customer
    //Commercial Customer
    //Done

    // The Main class should have methods that get data entry from the user about the
    // Residential or Commercial customer and should display all of the information in the
    // form of a quote.

    public static void main(String[] args) {
        // Define user input and make a menu to determine residential or commercial customers/clients.

        Scanner input = new Scanner(System.in);  // used for user input
        int mainSelect = 0; // the main screen user selection (integer value)

        do {  // Create a user friendly menu

            System.out.print("----------------Slick Rick's Lawn Services-----------------------\n");
            System.out.print("---------Employee Access Only - Others Unauthorized--------------\n");
            System.out.print("-------------Select the type of client below:--------------------\n");
            System.out.print("1. Residential\n");
            System.out.print("2. Commercial\n");
            System.out.print("3. Quit\n");
            mainSelect = input.nextInt();
        }
            while (mainSelect != 1 && mainSelect != 2 && mainSelect != 3) ;
            {
                input.nextLine();
            }
            if (mainSelect == 1) {
                residential();

            }else if (mainSelect == 2){
                commercial();
        }   else {
                System.exit(0);
            }

        }







        private static void residential () {

            //A residential class which extends customer that has:
            //A constant rate at $6 per 1000 square feet
            //A senior field
            //A method that calculates weekly charges, if the senior field is set to true then provide a 15% discount.
            //The method should display all information about the customer, the property, and the weekly charge.

            // VARIABLES LISTED HERE:
            Scanner input = new Scanner(System.in);  // used for user input
            boolean senDiscount;
            String chkDiscount;

            // Collect input to be used in other Classes.  Customer Last Name, Customer First Name, customerAddress, Phone, Senior, property size
//            System.out.println("Enter The Customer's First Name: ");
//            String customerFName = input.nextLine();

            System.out.println("Enter The Customer's Name: ");
            String customerName = input.nextLine();

            System.out.println("Enter The Customer's Address: ");
            String customerAddress = input.nextLine();

            System.out.println("Enter the Customer Phone Number: ");
            long customerPhone = input.nextLong();

            System.out.println("What is the square footage of the property? ");
            Double squareFootage = input.nextDouble();

            // The discount doesn't work 10/17/2018.  Just skips over this option.  NEED TO EVALUATE @1953 HOURS SK
            // SK100718 @ 2204 - Corrected by making input.next as opposed to input.nextLine();
            System.out.println("Does the Residential Client qualify for a Senior discount (55 years or older) ? Y or y if Yes.  Anything else will default to No discount ");
//            String senDiscount = input.next();  10/07/2018 Removing discount as a string, needs to be yes or no. BOOLEAN
            chkDiscount = input.next();
//                if(chkDiscount = "y" || chkDiscount = "Y");
            if (chkDiscount.equalsIgnoreCase("y")) {
                senDiscount = true;
            }else {
                senDiscount = false;
            }



            // Information will now be sent to Residential class - resCalc method.

            Residential customer = new Residential(customerName, customerPhone, customerAddress, squareFootage, senDiscount);
            //variables set to Residential()
            customer.resCalc();

            //


        }

        private static void commercial () {

            //A Commercial class which extends customer that has:
            // Property name
            //A constant commercial rate at $5 per 1000 square feet (a 10,000 sqft property will be charged $50 dollars
            // per week)
            //A multi-property field
            //A method that calculates weekly charges, if they have multiple properties provide a 10% discount. The
            // method should display all information about the customer, the property, and the weekly charge.

            Scanner input = new Scanner(System.in);  // used for user input
            String chkDiscount = input.nextLine();
            Boolean senDiscount;

            System.out.println("Enter The Business Name: ");
            String customerName = input.nextLine();

            System.out.println("Enter The Business Address: ");
            String customerAddress = input.nextLine();

            System.out.println("Enter the Business Phone Number: ");
            long customerPhone = input.nextLong();

            System.out.println("What is the square footage of the property? ");
            Double squareFootage = input.nextDouble();

            System.out.println("Does the client have multiple properties) ? Y or y if Yes.  Anything else will default to No discount ");
            chkDiscount = input.next();
            if (chkDiscount.equalsIgnoreCase("y")) {
                senDiscount = true;
            }else {
                senDiscount = false;
            }





            // Information will now be sent to Commercial class - comCalc method.

            Commercial customer = new Commercial(customerName, customerPhone, customerAddress, squareFootage, senDiscount); // SENDISCOUNT IS A STUPID NAME, DISCOUNT WOULD BE FINE
            //variables set to Residential()
            customer.comCalc();

            //


        }
    }
