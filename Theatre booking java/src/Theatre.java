import java.io.PrintStream;
import java.util.ArrayList;         // import the Arraylist class
import java.util.Scanner;           // To get the input, import the Scnner class
import java.io.FileWriter;          // Import the FileWriter class
import java.io.IOException;         // Import the IOException class to handle errors
import java.io.File;                //Import the File class
public class Theatre{
    static Scanner input = new Scanner(System.in);      //From the Scanner class create an object called input

    private static int[] Row1 = new int[12];       // declaring and initialize Row 1
    private static int[] Row2 =new int[16];        // declaring and initialize Row 2
    private static int[] Row3 =new int[20];        // declaring and initialize Row 3
    private static ArrayList<Ticket> ticketInfo = new ArrayList();  // Declaring the ArrayList with the Ticket class
    public static void main(String[] args) {       //Create the  main method

        System.out.println("Welcome to the New Theatre");
        while(true) {
            System.out.println("------------------------------------------------\n" +
                    "Please select an option(a Number):\n" +
                    "1) Buy a ticket\n" +
                    "2) Print seating area\n" +                                           // Shows the options to the user
                    "3) Cancel ticket\n" +
                    "4) List available seats\n" +
                    "5) Save to file\n" +
                    "6) Load from file\n" +
                    "7) Print ticket information and total price\n" +
                    "8) Sort tickets by price\n" +
                    "    0) Quit\n" +
                    "------------------------------------------------ ");
            try {
                System.out.println("Enter option:");
                int option = input.nextInt();           //get the user input to select an option
                switch (option) {                       //control structure to select an option
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save_file();
                        break;
                    case 6:
                        load_file();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                       sort_tickets(ticketInfo);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.Please try again.");
                }
            }
            catch(Exception e){                                                 //If the option is not an integer
                                                                                // this block will executed
                //System.out.println(e);
                System.out.println("Invalid input.Please enter an integer.");
                input.next();
            }
        }
    }


    public static void buy_ticket() {                    //method called buy_ticket
        while(true) {
            System.out.println("Enter the first name: ");   //prompt for the name
            String name = input.next();                     //get name
//            String nameValid = "^[a-zA-Z]+$";           //got by stackoverflow ,only characters allowed and not numbers
//            if (!name.matches(nameValid)) {
//                System.out.println("Invalid first name.Please try again.");
//                continue;
//            }
            System.out.println("Enter the surname: ");      //prompt for the surname
            String surname = input.next();                  //get surname
//            if(!surname.matches(nameValid)){
//                System.out.println("Invalid surname.Please try again.");
//                continue;
//            }
            System.out.println("Enter email:");               //prompt for email
            String email = input.next();                      //get email

            //for email validation got by stackoverflow
            if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
                System.out.println("Invalid email.Please try again.");
                continue;
            }


            System.out.println("Input a Row number(1-3): ");
            int rowNumber = input.nextInt();                                //read the row number(also initialize the rowNumber here)
            int seatNumber = 0;                                             // Seat number declaring and initializing here
            if (rowNumber == 1) {
                System.out.println("Please select a seat from (1-12) in Row 1: ");
                seatNumber = input.nextInt();
                if (seatNumber <= 12) {
                    if (Row1[seatNumber - 1] == 0) {
                        System.out.println("You have selected seat " + seatNumber + " in row 1.");
                        Row1[seatNumber - 1] = 1;                           // if Row number equals to 1 and get the right seat number this block will execute
                    } else {
                        System.out.println("The seat is occupied.");
                        continue;                                          // if the seat already occupied this block will execute
                    }
                } else if (seatNumber >= 13) {
                    System.out.println("The seat does not exist");        // if the input is an integer but not according to the seat number, this block will execute
                    continue;
                }

            }
            else if (rowNumber == 2) {
                System.out.println("Please select a seat from (1-16) in Row 2: ");
                seatNumber = input.nextInt();
                if (seatNumber <= 16) {
                    if (Row2[seatNumber - 1] == 0 ) {
                        System.out.println("You have selected seat " + seatNumber + " in row 2.");
                        Row2[seatNumber - 1] = 1;                       // if Row number equals to 2 and get the right seat number this block will execute
                    } else {
                        System.out.println("The seat is occupied.");
                        continue;                                       // if the seat already occupied this block will execute
                    }
                } else if (seatNumber >= 17) {
                    System.out.println("The seat does not exist");      // if the input is an integer but not according to the seat number, this block will execute
                    continue;
                }
            }
            else if (rowNumber == 3) {
                System.out.println("Please select a seat from (1-20) in Row 3: ");
                seatNumber = input.nextInt();
                if (seatNumber <= 20) {
                    if (Row3[seatNumber - 1] == 0) {
                        System.out.println("You have selected seat " + seatNumber + " in row 3.");
                        Row3[seatNumber - 1] = 1;                           // if Row number equals to 3 and get the right seat number this block will execute
                    } else {
                        System.out.println("The seat is occupied.");
                        continue;                                           // if the seat already occupied this block will execute
                    }
                } else if (seatNumber >= 21) {
                    System.out.println("The seat does not exist");          // if the input is an integer but not according to the seat number, this block will execute
                    continue;
                }
            }
            else {
                System.out.println("Invalid Row Number!");                  //if the input is an integer but not according to the row number, this block will execute
                continue;
            }

            //create an object called personObj from the Person class and store the input values in the constructor.
            Person personObj = new Person(name, surname, email);

            System.out.println("Enter the price:");                 //Ask for the price
            double price = input.nextDouble();                      // get the price and store it in the variable called price

            Ticket ticket = new Ticket(rowNumber,seatNumber,price,personObj);   //create an object called ticket from the Ticket class and store all the Name, Surname ,row,seat and price
            ticketInfo.add(ticket);                                             // add all the Name, Surname ,row,seat and price to the arraylist called ticketInfo
            break;
        }

    }
    public static void print_seating_area(){                            //method called print_seating_area
        System.out.println("    ***********");                          // printing the stage here
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");

        for(int i = 0; i < Row1.length ;++i) {
            if(i == 0) System.out.print("    ");
            if(i == 6) System.out.print(" ");
            if(Row1[i]==1){
                System.out.print('X');                              //checks the seat is occupied or not if occupied shows X in the seat
            }
            else System.out.print('O');                             //checks the seat is occupied or not if not occupied shows O in the seat
        }
        System.out.println();
        for(int i = 0; i < Row2.length ;++i) {
            if(i==0) System.out.print("  ");
            if(i == 8) System.out.print(" ");
            if(Row2[i]==1){
                System.out.print('X');                              //checks the seat is occupied or not if occupied shows X in the seat
            }
            else System.out.print('O');                             //checks the seat is occupied or not if not occupied shows O in the seat
        }
        System.out.println();
        for(int i = 0; i < Row3.length ;++i) {
            if(i == 10) System.out.print(" ");
            if(Row3[i]==1){
                System.out.print('X');                              //checks the seat is occupied or not if occupied shows X in the seat
            }
            else System.out.print('O');                             //checks the seat is occupied or not if not occupied shows O in the seat
        }
        System.out.println();
    }
    public static void cancel_ticket(){        //method called cancel_ticket

        System.out.println("Enter your row number:");
        int RowNumber = input.nextInt();
        int SeatNumber=0;                     //Variable SeatNumber have been initialized
        switch (RowNumber){
            case 1:
                System.out.println("Enter your seat number:");
                SeatNumber = input.nextInt();
                if(SeatNumber > 0 && SeatNumber <= 12){
                    if(Row1[SeatNumber-1]== 1){                                     //check the seat is booked or not
                        System.out.println("You cancelled your booking seat");
                        Row1[SeatNumber-1]=0;                                       // if the seat is booked this code will execute and cancelled the booking seat
                    }
                    else System.out.println(SeatNumber+" this seat is not booked");   // if the seat is not booked this block will execute
                }
                else {
                    System.out.println("Invalid seat number.");                     // if the input is an integer but not valid seat number this block will execute
                }
                break;
            case 2:
                System.out.println("Enter your seat number:");
                SeatNumber = input.nextInt();
                if(SeatNumber > 0 && SeatNumber <= 16){
                    if(Row2[SeatNumber-1] == 1){                                    //check the seat is booked or not
                        System.out.println("You cancelled your booking seat.");
                        Row2[SeatNumber - 1] = 0;                                   // if the seat is booked this code will execute and cancelled the booking seat
                    }
                    else{
                        System.out.println(SeatNumber+" this seat is not booked.");     // if the seat is not booked this block will execute
                    }
                }
                else{
                    System.out.println("Invalid seat number.");                 // if the input is an integer but not valid seat number this block will execute
                }
                break;
            case 3:
                System.out.println("Enter your seat number:");
                SeatNumber = input.nextInt();
                if(SeatNumber>0 && SeatNumber<=20){
                    if(Row3[SeatNumber-1]==1){                                  //check the seat is booked or not
                        System.out.println("You cancelled your booking seat.");
                        Row3[SeatNumber-1] = 0;                                 // if the seat is booked this code will execute and cancelled the booking seat
                    }
                    else{
                        System.out.println(SeatNumber+" this seat is not booked.");     // if the seat is not booked this block will execute
                    }
                }
                else{
                    System.out.println("Invalid seat number.");                 // if the input is an integer but not valid seat number this block will execute
                }
                break;
            default:
                System.out.println("Invalid Row number");                       // if the input is an integer but not valid row number this block will execute
        }


        //when cancelling a ticket, it removes the ticket from the array list of tickets.
        if
        ((RowNumber==1 && SeatNumber>=1 && SeatNumber <=12) ||(RowNumber==2 && SeatNumber>=1 && SeatNumber <=16 ) || (RowNumber==3 && SeatNumber>=1 && SeatNumber <=20)){
            for(Ticket element: ticketInfo){
                if(element.getRow()==RowNumber && element.getSeat()==SeatNumber){   // if the row number and seat number entered correctly this block will execute and delete that
                    ticketInfo.remove(element);                                     // seat number,row number,name and email from the array list
                    System.out.println("Ticket deleted successfully.");
            }

            }
        }




    }
    public static void show_available(){   //method called show_available
        System.out.print("Seats available in Row 1 are: ");
        for(int i = 0;i<12;i++){
            if(Row1[i]==0){                     // check the availability of the seats in 1 row
                System.out.print(i+1+" ");
            }
        }
        System.out.println();
        System.out.print("Seats available in Row 2 are: ");
        for(int i = 0; i<16 ;i++){
            if(Row2[i]==0){                     // check the availability of the seats in 2 row
                System.out.print(i+1+" ");
            }
        }
        System.out.println();
        System.out.print("Seats available in Row 3 are: ");
        for(int i = 0; i<20 ;i++) {
            if (Row3[i] == 0) {                     // check the availability of the seats in 3 row
                System.out.print(i+1+" ");
            }
        }
        System.out.println();
    }
    public static void save_file(){         //method called save_file
        try{
            FileWriter mywriter = new FileWriter("Save_File.txt");    //create a file called Save_File.txt and start to writing to it.
            for( int seat: Row1){
                mywriter.write(Integer.toString(seat)+" ");          //convert the integer data type to string data type to write on the file
            }
            mywriter.write("\n");
            for(int seat: Row2){
                mywriter.write(Integer.toString(seat)+" ");         //convert the integer data type to string data type to write on the file
            }
            mywriter.write("\n");
            for(int seat: Row3){
                mywriter.write(Integer.toString(seat)+" ");         //convert the integer data type to string data type to write on the file
            }
            mywriter.close();
            System.out.println("All rows' information have been saved to the file.");
        }
        catch(IOException e){
            System.out.println(e+": This error has occurred. ");        // if an error happens from the save method this block will execute
        }
    }
    public static void load_file(){         //method called load_file
        try{
            int RowNumber = 1;
            File loadFile = new File("Save_File.txt");          //load a file called Save_File.txt
            Scanner readFile = new Scanner(loadFile);                    // Scanning the load file
            while(readFile.hasNextLine()){
                String rowLine = readFile.nextLine();                   //read the load file
                System.out.print(RowNumber + " row's information: ");
                System.out.println(rowLine);
                RowNumber++;
            }
            readFile.close();
        }
        catch(Exception e){
            System.out.println("Error while loading the file.");            // if an error happens from the load method this block will execute
        }
    }

    public static void show_tickets_info(){
        double total_price =0.0;
        for(Ticket element: ticketInfo){                    // show ticket information from the array list
            element.print();                                // print the array list
            System.out.println();
        }
       for (int i = 0 ; i < ticketInfo.size();i++){
           total_price += ticketInfo.get(i).getPrice();    // get the total price from the array list
       }
        System.out.println("Total price is "+total_price);
    }


    public static void sort_tickets(ArrayList<Ticket> ticketInfo){
        for(int i = 0;i <ticketInfo.size();i++){
            //code here
        }
            //unable to do the sorting part


    }
}


