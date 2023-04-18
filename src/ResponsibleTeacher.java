import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher  {
    
    //Attributes

    private List<DesignatedCourse> courses = new ArrayList<>();

    //Constructors

    public ResponsibleTeacher(String lname, String fname){
        super(lname, fname);
    } 

    //Methods

    
    protected String getEmployeeIdString() {
        
        return "OY_TEACHER_";
    }

    public String getCourses(){
        String string = "";
        for (DesignatedCourse dc : courses){
            if (dc != null){
                if (dc.isResponsible()){
                    string += "\t" + "Responsible teacher: " + dc.toString() + "\n";
                }else{
                    string += "\t" + "Teacher: " + dc.toString() + "\n";
                }
        }
    }
        return string;
    }

    public void setCourses (List<DesignatedCourse> courses){
        if (courses != null){
            this.courses = courses;
        }
    }

    public String toString(){
        return "Teacher id: " + getIdString() + "\n\t" + "First name: " + getFirstName() + ", " + "Last name: " + getLastName() + "\n\t"
        + "Birthdate: " + getBirthDate() + "\n\t" + "Salary: " + getPayment().calculatePayment() +  "\n\t" + "Teacher for courses: \n" + getCourses();
         }
}


