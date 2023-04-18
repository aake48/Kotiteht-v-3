import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher {
    
    // Attributes

    private List<DesignatedCourse> courses = new ArrayList<>();

    //Constructors

    public AssistantTeacher(String lname, String fname){
        super(lname, fname);
        
    }

    //Methods 

    protected String getEmployeeIdString(){
        return "OY_ASSISTANT_";
    }

    public String getCourses() {
        String string = "";
        for(DesignatedCourse i : courses){
            if (i != null){
           string += "\t" + i.toString() + "\n";
            }
        }
        return string;
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null){
            this.courses = courses;
        }
    }

    public String toString(){
        return "Teacher id: " + getIdString() + "\n\t" + "First name: " + getFirstName() + ", Last name: " + getLastName() + "\n\t" +
        "Birthdate: " + getBirthDate() + "\n\t" + String.format ("Salary: %.2f", getPayment().calculatePayment()) + "\n\t" + "Assistant for courses: \n\t" + getCourses()
        ;
    }

    
}
