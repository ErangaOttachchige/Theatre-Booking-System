import org.w3c.dom.ls.LSOutput;

public class Ticket  {
    private int row;                //Attributes
    private int seat;               //Attributes
    private double price;           //Attributes
    private Person person;          //Attributes

    //Constructor
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;             //this. --> class scope variable = argument
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public void print(){
        System.out.println("Person's Name: "+person.getName());
        System.out.println("Person's Surname: "+person.getSurname());
        System.out.println("Person's Email: "+person.getEmail());
        System.out.println("Person's Row: "+row);
        System.out.println("Person's Seat: "+seat);
        System.out.println("Person's price: "+price);
    }

    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }
    public Person getPerson() {
        return person;
    }
}

