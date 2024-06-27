public class Person {
    private String name;        //Attributes
    private String surname;     //Attributes
    private String email;       //Attributes


    public Person(String name, String surname, String email) {  //Constructor
        this.name = name;            //this. --> class scope variable = argument
        this.surname = surname;
        this.email = email;
    }

    String getName(){    // A getter form the name attribute
        return name;
    }
    String getSurname(){
        return surname;  // A getter form the surname attribute
    }
    String getEmail(){
        return email;   // A getter form the email attribute
    }
}
