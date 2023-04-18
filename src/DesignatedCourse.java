import java.time.*;
public class DesignatedCourse {

    //Attributes
    
    private Course course;
    private boolean responsible;
    private int year;

    //Constructors

    public DesignatedCourse(){

    }
    public DesignatedCourse(Course course, boolean resp, int year){
        setCourse(course);
        setResponsible(resp);
        setYear(year);
        

    }
   

    // Methods

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null){
            this.course = course;
        }
    }

    //False = not responsible, true = responsible
    public boolean isResponsible() {
        if (getResponsible()){
            return true;
        }else{
            return false;
        }
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean getResponsible(){
        return responsible;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2000 && year <= (Year.now().getValue() + 1)){
            this.year = year;
        }
    }

    public String toString(){
        return "[course=" + getCourse().toString() + ", year=" + getYear() + "]";
    }
    
}
