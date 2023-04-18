import java.util.Random;
public abstract class Person {
    
    //Attributes

    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    //Constructors

    public Person (String lname, String fname){

        setFirstName(fname);
        setLastName(lname);
    }

    //Methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null){
        this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null){
        this.lastName = lastName;
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    //Sets birthdate for the student, utilizes the personId class method "setPersonId"
    public String setBirthDate(String personId){

        PersonID pr = new PersonID();
        if (personId != null){
        if(pr.setPersonId(personId).equals("Ok")){
            birthDate = pr.getBirthDate();
        }else{
            return "No change";
        }
    }else{
        return "No change";
    }
        return birthDate;
    }
    
    //Method that gives a random number between min and max
    protected int getRandomId(final int min, final int max){

        Random randLuku = new Random();
        int luku = 0;

        luku = min + randLuku.nextInt((max - min) + 1);
        return luku;

    }

    public abstract String getIdString();

    
}
