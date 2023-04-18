import java.util.ArrayList;
import java.util.List;
public class Degree {


    //Attributes
    private static final int MAX_COURSES = 50;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>(MAX_COURSES);

    public List<StudentCourse> getCourses(){
        return myCourses;
    }
    
    public void addStudentCourses(List<StudentCourse> courses){


        if (courses != null){
        for (int i = 0; i < courses.size(); i++){
            if(addStudentCourse(courses.get(i)));

            
        }
    }
    }

    public boolean addStudentCourse(StudentCourse course){

        if (course != null && myCourses.size() < MAX_COURSES){
            myCourses.add(course);
            return true;
        }else{
        return false;
        }
    }

    public String getDegreeTitle(){
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle){
        if (degreeTitle != null){
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis(){
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis){
        if (titleOfThesis != null){
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base){

        double credits = 0.0;
        //Converting the given parameter to uppercase
        base = Character.toUpperCase(base);

         for (StudentCourse i: myCourses){
            if (isCourseCompleted(i)){
                if (i.getCourse().getCourseBase() == base){
                    credits = credits + i.getCourse().getCredits();
                }
            }
        }
        return credits;

    }

    public double getCreditsByType(final int courseType){
        double credits = 0.0;
        for (StudentCourse i : myCourses){
            if (isCourseCompleted(i)){
                if (i.getCourse().getCourseType() == courseType){
                    credits = credits + i.getCourse().getCredits();
                }
            }
        }
        return credits;
    }

    public double getCredits(){
        double credits = 0.0;
        for (StudentCourse i : myCourses){
        if (isCourseCompleted(i)){
            credits = credits + i.getCourse().getCredits();
        }

        } 
        return credits;
    }

    private boolean isCourseCompleted(StudentCourse c){
        if (c != null && c.getCourse().isNumericGrade() && c.isPassed() == true){
            return true;
        }else if (c != null && !c.getCourse().isNumericGrade() && c.isPassed() == true) {
            return true;
        }else{
            return false;
        }
    }

    public void printCourses(){

        for (StudentCourse i : myCourses){
            if (i != null){
                System.out.println(i);
            }
        }
    }

    public List<Double> getGPA(int type){

        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;

        List<Double> list = new ArrayList<>();

        //Getting the sum of grades and getting the amount of courses with numericgrading and calculating the average of the grades
        //
        if (type == ConstantValues.ALL){
            for (StudentCourse i : myCourses){
                if (i != null){
                if (i.getCourse().isNumericGrade()){
                    sum += i.getGradeNum();
                    count++;
                    
                }
            }
            }
        }else{
        for (StudentCourse i : myCourses){
            if (i != null){
                if (i.getCourse().isNumericGrade() && i.getCourse().getCourseType() == type){
                    sum += i.getGradeNum();
                    count++;
                }
    
            }
        }
        }



        if (count != 0){
            average = sum / count;
        }

        //Adding sum, count and average to the list
        list.add(0, sum);
        list.add(1, count);
        list.add(2, average);

        return list;
    }

    //Returns the courses in a string format for printing
    private String coursesToString(){

        String mjono = " ";
        for (int i = 0; i < myCourses.size(); i++){
            if(myCourses.get(i) != null){                                       
            mjono = mjono + "\n\t" + (i+1) + ". " + myCourses.get(i).toString();
            }
        }
        return mjono;
    }
    
    //Returns the amount of courses for the degree
    private double getCourseCount(){
        double count = 0;
       for (StudentCourse i : myCourses){
            if (i != null){
                count++;
            }
       }
       return count;
    }

    //Returns the amount of courses with numeric grading for the degree
    public double getCourseNumCount(){
        double numCount = 0.0;
        for(StudentCourse i : myCourses){
            if (i != null){
                if (i.getCourse().isNumericGrade()){
                    numCount++;
                }
            }
        }
        return numCount;
    }


    @Override
    public String toString() {
        return "Degree [Title: " + '"' + getDegreeTitle() + '"' + String.format(" (courses: %.0f)", getCourseCount()) + "\n\t"
                + "Thesis title: " + '"' + getTitleOfThesis() + '"' + coursesToString() + "]" + "\n";
    }

}
//Kysy tuosta averagen laskemisesta, to string viel kuntoo studentin jälkeen " (courses: " + getGPA(0).get(1) + ")"

//String.format(" (courses: %.0f)", getGPA(1).get(1) + getGPA(0).get(0))

//KATO SE getGPA UUDESTAAN 0 = OPTIONAL, 1 = MANDATORY, 2 = ALL UNOHTU TOI KOKONAA