public class Course {

    //Attributes
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period = 0;
    private double credits;
    private boolean numericGrade;

    //Constructors
    //Default constructor
    public Course (){

    }
    /*The constructor must set the attribute values (and check for valid
    values for most of those – preferably by utilizing methods of the
    class (setName, setCourseCode, setCourseType, setPeriod,
    setCredits) */
    public Course (String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade){

        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);


    }
        //Copy constructor
    public Course (final Course course){

        //this(course.name, course.code, course.courseBase, course.courseType, course.period, course.credits, course.numericGrade);
        
         setName(course.name);
        setPeriod(course.period);
        setCourseType(course.courseType);   
        this.courseCode = course.getCourseCode();
        setCredits(course.credits);
        setNumericGrade(course.numericGrade);
        this.courseBase = course.getCourseBase();
            
        
    }


        //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.isEmpty() == false){
        this.name = name;
        }
    }
    //gets the course type in string format
    public String getCourseTypeString() {
        String mjono;
        if (getCourseType() == 0){
            mjono = "Optional";
        }else if (getCourseType() == 1){
            mjono = "Mandatory";
        }else{
            mjono = "Invalid course type";
        }
        return mjono;
    }

    public int getCourseType() {

        return courseType;
    }

    //Sets the coursetype if the given integer type is 0 = optional or 1 = mandatory
    public void setCourseType(final int type) {
        if (type == 0 || type == 1){
            courseType = type;
        }
    }

    public String getCourseCode() {
        return courseCode;
    }
    //Sets the coursecode and coursebase 
    public void setCourseCode(final int courseCode, Character courseBase) {

        courseBase = Character.toUpperCase(courseBase);
        if (courseCode > 0 && courseCode < 1000000){
            if(courseBase == 'A' || courseBase == 'P' || courseBase == 'S' || courseBase == 'a'){
            this.courseCode = Integer.toString(courseCode);
            this.courseCode += courseBase;
            this.courseBase = courseBase;
            }
        }
    }

    public Character getCourseBase() {
            return courseBase;
        }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(final int period) {
        if(period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD){
        this.period = period;
        }
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS){
        this.credits = credits;
        }
    }

    public boolean isNumericGrade() { 

        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
            this.numericGrade = numericGrade;
    }
    @Override
    public String toString() {


        return String.format("[%s (%5.2f cr), \"%s\". %s, period: %s.]", getCourseCode(), getCredits(), getName(), getCourseTypeString(), getPeriod());
        //return "[" + getCourseCode() +  " (" + credits + " cr), " + '"' + getName() + '"' + ". " + getCourseTypeString() + ", period: " + getPeriod() + ".]";

        

    }
    
}
