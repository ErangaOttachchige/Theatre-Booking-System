# New Theatre Seat Management System
Welcome to the New Theatre Seat Management System. This Java project is designed to manage and control the seats sold and those still available for one of the theatre sessions. The theatre floorplan consists of 3 rows with 12, 16, and 20 seats respectively.

Project Structure
Theatre.java: Main program file.
Person.java: Class file representing a person.
Ticket.java: Class file representing a ticket.
Part A: Main Program
Task 1: Initialize Theatre
Create a project named Theatre.
The Theatre class should include a main method that displays Welcome to the New Theatre.
Add 3 arrays to keep track of seats. Row 1 has 12 seats, row 2 has 16 seats, and row 3 has 20 seats. 0 indicates a free seat, 1 indicates an occupied seat. Initially, all seats are free.
Task 2: Menu Options
Add a menu with the following options:

Buy a ticket
Print seating area
Cancel ticket
List available seats
Save to file
Load from file
Print ticket information and total price
Sort tickets by price
Quit
Task 3: Buy Ticket
Create a buy_ticket method that:

Asks for a row number and seat number.
Validates the input and seat availability.
Marks the seat as occupied.
Task 4: Print Seating Area
Create a print_seating_area method that:

Displays seats using O for available and X for sold.
Aligns the display with the stage.
Task 5: Cancel Ticket
Create a cancel_ticket method that:

Asks for a row number and seat number.
Validates the input and seat occupancy.
Marks the seat as available.
Task 6: List Available Seats
Create a show_available method that:

Displays available seats for each row.
Task 7: Save to File
Create a save method that:

Saves the seat arrays to a file.
Task 8: Load from File
Create a load method that:

Loads the seat arrays from a file.
Part B: Classes and Objects
Task 9: Person Class
Create a Person class with:

Attributes: name, surname, email.
Constructor to initialize these attributes.
Task 10: Ticket Class
Create a Ticket class with:

Attributes: row, seat, price, Person.
Constructor to initialize these attributes.
Task 11: Print Ticket Information
Add a print method in Ticket class that:

Prints ticket information including the person's name, surname, email, row, seat, and price.
Task 12: Manage Tickets Array List
Add an array list in the main program to store tickets.
Extend buy_ticket to ask for person information, create a new ticket, and add it to the list.
Extend cancel_ticket to remove the ticket from the list.
Task 13: Show Ticket Information and Total Price
Create a show_tickets_info method that:

Prints information for all tickets.
Calculates and shows the total price of all tickets.
Task 14: Sort Tickets by Price
Create a sort_tickets method that:

Returns a list of tickets sorted by price in ascending order.
Prints sorted ticket information including price.
Running the Program
To run the program, compile and execute Theatre.java. Follow the on-screen menu to manage theatre seating.

Example Usage
Welcome to the New Theatre
----------------------------
Please select an option:
1) Buy a ticket
2) Print seating area
3) Cancel ticket
4) List available seats
5) Save to file
6) Load from file
7) Print ticket information and total price
8) Sort tickets by price
0) Quit
----------------------------
Enter option:

Choose the desired option and follow the prompts to manage the seating arrangements.

Conclusion
This program provides a comprehensive solution for managing the seating of the New Theatre, ensuring efficient ticket sales, cancellations, and seat availability tracking.
