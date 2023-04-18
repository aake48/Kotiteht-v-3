import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    
    //Attributes

    private int id;
    //private int startYear = Year.now().getValue();
    private int startYear = 2001;
    private int graduationYear = 0;
    private List<Degree> degrees = new ArrayList<Degree>();

    //Constructors

    public Student (String lname, String fname){
        super(lname, fname);
        id = super.getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);

        //Creating the objects for the List
        for (int i = 0; i < 3; i++){
            degrees.add(i, new Degree());
        }


    
    }


    //Methods

    public int getId(){
        return id;
    }

    //Sets the id of the student as long as the value of id is between 1-100
    public void setId(final int id) {
        
        if(id <= ConstantValues.MAX_STUDENT_ID && id >= ConstantValues.MIN_STUDENT_ID){
                this.id = id;
        }
            
    }

    public int getStartYear() {
        return startYear;
    }

    //sets the start year for the studies as long as the startYear is 2000 < startYear <= current year
    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Year.now().getValue()){ 
        this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }
    // KORJAA KATO UUSIKS TOSTA PDF
    //Method that sets the graduation year for the student
    public String setGraduationYear(final int graduationYear) {
        String mjono = "";

         if (!canGraduate()){
            mjono = "Check amount of required credits";
        }else if (graduationYear >= startYear && graduationYear <= Year.now().getValue()){
            this.graduationYear = graduationYear;
            mjono = "Ok";
        }else{
            mjono = "Check graduation year";
        }
        
        return mjono;
    }

    public void setDegreeTitle(final int i, String dName){

        if (i >= 0 && i < degrees.size() && dName != null){
            if (degrees.get(i) != null){
            degrees.get(i).setDegreeTitle(dName);
            }
        }

    }
    public boolean addCourse (final int i, StudentCourse course){
        if ((i >= 0 && i < degrees.size()) && course != null){
            if (degrees.get(i).addStudentCourse(course)){
                return true;
            }
        }
        return false; 
    }

    public int addCourses (final int i, List<StudentCourse> courses){
        int count = 0;
            

        if (i >= 0 && i < degrees.size() && (!degrees.isEmpty()) && courses != null){
            for (StudentCourse course : courses){
                if(addCourse(i, course)){
                    count++;
                }
            }
        }
        return count; 
    }


    //Returns true if the student has graduated
    public boolean hasGraduated(){
        if (graduationYear != 0){
            return true;
        }else{
            return false;
        }
    }

    public void printCourses(){
        for (Degree i : degrees){
            if (i != null){
                for (StudentCourse course : i.getCourses()){
                    if (course != null){
                        System.out.println(course.toString());
                    }
                }
            }            
        }
    }

    public void printDegrees(){
        for (Degree i : degrees){
            if (i != null){
                System.out.println(i.toString());
            }
        }
    }

    public void setTitleOfThesis(final int i, String title){

        if (i >= 0 && i < 3 && title != null){
            degrees.get(i).setTitleOfThesis(title);
        }
    }

    public boolean canGraduate(){
        if(degrees.get(0).getDegreeTitle() != ConstantValues.NO_TITLE && degrees.get(0).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY && degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS
        && degrees.get(1).getDegreeTitle() != ConstantValues.NO_TITLE && degrees.get(1).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY && degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS){
            return true;
        }else{
            return false;
        }
        
    }

    //Returns the study years of the student
    public int getStudyYears(){
        int studyYears;
        if (hasGraduated()){
            studyYears = graduationYear - startYear;
        }else{
            studyYears = Year.now().getValue() - startYear;
        }
        return studyYears;
    }

    //Method that tells in String format if the student has graduated or not
    //Used for printing
    private String checkStatus(){
        String status = "";
        if (hasGraduated() && canGraduate()){
            status = "The student has graduated in " + graduationYear;
        }else{
            status = "The student has not graduated, yet";
        }
        return status;
    }

    //Method that counts the total credits of the student, used for printing
    private double countTotalCredits(){
        double total = 0;
        for (Degree i : degrees){
            total = total + i.getCredits();
        }
        return total;
        }
    
    //Method that gets the degrees thesis title, used for printing
    public String getTitleOfThesis(final int i){
        return degrees.get(i).getTitleOfThesis();
     }

    //Method that returns the students credits (parameter i is for degree: 0 = bachelor, 1 = master, 2 = doctoral studies)
    private double getCredits(final int i){
        return degrees.get(i).getCredits();
    } 
    
    //Method that returns a string and counts the students credits of the degree, used for printing
    private String countDegreeCredits(final int i){

        String mjono = " ";
        if (i == ConstantValues.BACHELOR_TYPE){
        if (degrees.get(i).getCredits() >= ConstantValues.BACHELOR_CREDITS){
            mjono = String.format("Total bachelor credits completed (%s/%s)", degrees.get(i).getCredits(), ConstantValues.BACHELOR_CREDITS);
        }else{
            mjono = String.format("Missing bachelor credits %s (%s/%s)", (ConstantValues.BACHELOR_CREDITS-degrees.get(i).getCredits()), degrees.get(i).getCredits(), ConstantValues.BACHELOR_CREDITS);
        }
    }
        if (i == ConstantValues.MASTER_TYPE){
        if (degrees.get(i).getCredits() >= ConstantValues.MASTER_CREDITS){
            mjono = String.format("Total master's credits completed (%s/%s)", degrees.get(i).getCredits(), ConstantValues.MASTER_CREDITS);
        }else{
            mjono = String.format("Missing master's credits %s (%s/%s)", (ConstantValues.MASTER_CREDITS - degrees.get(i).getCredits()), degrees.get(i).getCredits(), ConstantValues.MASTER_CREDITS);
        }
    
    }
    return mjono;
    }

    //Returns the sum of course grades for the given degree
    private double getSumOfDegree(final int i){
        return degrees.get(i).getGPA(2).get(0);
    }
    //Returns the count of courses with numeric grading for the given degree
    private double getNumCountOfDegree(final int i){
        return degrees.get(i).getCourseNumCount();
    }

    private double getGPAOfDegree(final int i){
        return degrees.get(i).getGPA(2).get(2);
    }

    // Counts the GPA for the student
    private double countGPA(){
       return (getSumOfDegree(ConstantValues.BACHELOR_TYPE) + getSumOfDegree(ConstantValues.MASTER_TYPE) / (getNumCountOfDegree(ConstantValues.BACHELOR_TYPE) + getNumCountOfDegree(ConstantValues.MASTER_TYPE)));
    }

    //Gives the amount of credits for mandatory courses for given degree in string format
    //used for printing
    private String checkMandatoryCreditsOfDegree(final int i){

        String string = "";
        
        if (i == 0){
            if(degrees.get(i).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY){
                string = String.format("All mandatory bachelor credits completed (%.1f/%.1f)", degrees.get(i).getCreditsByType(1), ConstantValues.BACHELOR_MANDATORY);
           }else{
                string = String.format("Mandatory bachelor credits missing (%.1f/%.1f)", degrees.get(i).getCreditsByType(1), ConstantValues.BACHELOR_MANDATORY);
           }
        }

        if (i == 1){
            if (degrees.get(i).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY){
                string = String.format("All mandatory master credits completed (%.1f/%.1f)", degrees.get(i).getCreditsByType(1), ConstantValues.MASTER_MANDATORY);
            }else{
                string = String.format("Mandatory master credits missing (%.1f/%.1f)", degrees.get(i).getCreditsByType(1), ConstantValues.MASTER_MANDATORY);
            }
        }
        return string;
    }

    
    public String getIdString(){

        return "Student id: " + getId();
    }

    @Override
    public String toString() {
        return getIdString() + "\n\t" + "First name: " +  getFirstName() + ", Last name: " + getLastName() + "\n\t" + "Date of birth: " + getBirthDate() + "\n\t" +
                "Status: " + checkStatus() + "\n\t" + "Start year: " + getStartYear() + " studies have lasted for " + getStudyYears() + " years)" + "\n\t" + "Total credits: " + countTotalCredits() + String.format (" (GPA = %.2f) ", countGPA())
                 + "\n\t" + "Bachelor credits: " + getCredits(0) + "\n\t\t" + countDegreeCredits(0) + "\n\t\t" + checkMandatoryCreditsOfDegree(0) + "\n\t\t" + String.format("GPA of Bachelor studies: %.2f", getGPAOfDegree(0))
                  + "\n\t\t" + "Title of BSc thesis: " + '"' + getTitleOfThesis(0) + '"' + "\n\t" + "Master credits: " + getCredits(1) + "\n\t\t" +  countDegreeCredits(1) + "\n\t\t" + checkMandatoryCreditsOfDegree(1) + "\n\t\t" + String.format("GPA of Master studies: %.2f", getGPAOfDegree(1))
                 + "\n\t\t" + "Title of MSc Thesis: " + '"' + getTitleOfThesis(1) + '"' + "\n";
    }  


}
