import java.time.*;
public class StudentCourse {

    //Attributes
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    //Constructors
    
    //Default constructor
    public StudentCourse (){

    }
    //Constructor that sets given course, gradeNum and yearCompleted
    public StudentCourse (Course course, final int gradeNum, final int yearCompleted){

        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    //Methods

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum(){
        return gradeNum;
    }
    //The method checks whether the course is graded numerically or not, and check that the given value is at the accepted range
    //The method also sets yearCompleted to current year, if the year is not set already 
    protected void setGrade(int gradeNum){


        if (checkGradeValidity(gradeNum)){
            if (course.isNumericGrade()){
                this.gradeNum = gradeNum;
            }else{
                this.gradeNum = Character.toUpperCase(gradeNum);
            }
            
        }
        if (yearCompleted == 0){
            this.yearCompleted = Year.now().getValue();
        }
    }
    //Checks that the gradeNum is within accepted values
    private boolean checkGradeValidity(final int gradeNum){

        //Converting the gradeNum to uppercase in case the gradenum is 'a' or 'f' instead of 'A' or 'F'
        boolean retVal = false;
        int x = Character.toUpperCase(gradeNum);
        if (course.isNumericGrade()){
            if (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE){
                retVal = true;
            }
        }
        if (!course.isNumericGrade()){
            if (x == ConstantValues.GRADE_FAILED || x == ConstantValues.GRADE_ACCEPTED){
                retVal = true;
            }
        }
        return retVal;
    }
       /*  if (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE){
            return true;
        }else if (x == ConstantValues.GRADE_ACCEPTED || x == ConstantValues.GRADE_FAILED){
            return true;
        }else{
            return false;
        } */

    
    //Checks the gradeNum and returns true if the course is passed
    public boolean isPassed(){

        if (gradeNum == ConstantValues.MIN_GRADE || gradeNum == ConstantValues.GRADE_FAILED){
            return false;
        }else{
            return true;
        }

    }

    public int getYear(){
        return yearCompleted;
    }

    public void setYear(final int year){
        if (year <= Year.now().getValue() && year >= 2000){
            this.yearCompleted = year;
        }
    }


    //Converts the grade to string format for printing
    private String convertGrade(final int gradeNum){

    if (gradeNum == 'a' || gradeNum == 'A'){
        return "A";
    }else if (gradeNum == 'f' || gradeNum == 'F'){
        return "F";
    }else if (gradeNum == 0){
        return "Not graded";
    }else{
        return Integer.toString(this.gradeNum);
    }

}
        
    public String toString(){
        return course + " " + "Year: " + yearCompleted + ", Grade: " + convertGrade(gradeNum) + ".]";
    }

}

