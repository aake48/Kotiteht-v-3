import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        HourBasedPayment tuntipalkka = new HourBasedPayment();
        MonthlyPayment kkPalkka = new MonthlyPayment();
        kkPalkka.setSalary(756.85);
        ResponsibleTeacher vastuuOpe = new ResponsibleTeacher("Mouse", "Mickey");
        vastuuOpe.setBirthDate("230498-045T");
        vastuuOpe.setPayment(kkPalkka);
        AssistantTeacher apuOpe = new AssistantTeacher("The dog", "Goofy");
        tuntipalkka.setEurosPerHour(11);
        tuntipalkka.setHours(3.5);
        apuOpe.setPayment(tuntipalkka);
        apuOpe.setBirthDate("141200A2315");
        System.out.println(apuOpe.toString());
        System.out.println(vastuuOpe.toString());
        System.out.println(vastuuOpe.getEmployeeIdString());
        System.out.println(vastuuOpe.getEmployeeIdString());
        Student student = new Student("Duck", "Donald");


        

        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        List<DesignatedCourse> courseLista = new ArrayList<>();
        
        DesignatedCourse desiKurssi = new DesignatedCourse(course3, true, 2023);
        DesignatedCourse desiKurssi2 = new DesignatedCourse(course4, false, 2023);
        DesignatedCourse desiKurssi3 = new DesignatedCourse(course10, false, 2022);
        DesignatedCourse desiKurssi4 = new DesignatedCourse(course11, true, 2023);
        
        courseLista.add(desiKurssi);
        courseLista.add(desiKurssi2);
        courseLista.add(desiKurssi3);
        courseLista.add(desiKurssi4);

        vastuuOpe.setCourses(courseLista);
        apuOpe.setCourses(courseLista);



        System.out.println(vastuuOpe.getCourses());
        System.out.println(apuOpe.getCourses());




        StudentCourse kurssi1 = new StudentCourse(course1, 1, 2013);
        StudentCourse kurssi2 = new StudentCourse(course2, 1, 2014);
        StudentCourse kurssi3 = new StudentCourse(course3, 1, 2015);
        StudentCourse kurssi4 = new StudentCourse(course4, 4, 2016);
        StudentCourse kurssi5 = new StudentCourse(course5, 5, 2017);
        StudentCourse kurssi6 = new StudentCourse(course6, 1, 2018);
        StudentCourse kurssi7 = new StudentCourse(course7, 1, 2019);
        StudentCourse kurssi8 = new StudentCourse(course8, 1, 2020);
        StudentCourse kurssi9 = new StudentCourse(course9, 2, 2021);
        StudentCourse kurssi10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse kurssi11 = new StudentCourse(course11, 'f', 2022);


        List<StudentCourse> bachelorArrayList = new ArrayList<StudentCourse>();
        List<StudentCourse> masterArrayList = new ArrayList<StudentCourse>();
        bachelorArrayList.add(kurssi1);
        bachelorArrayList.add(kurssi2);
        bachelorArrayList.add(kurssi3);
        bachelorArrayList.add(kurssi4);
        bachelorArrayList.add(kurssi5);
        masterArrayList.add(kurssi6);
        masterArrayList.add(kurssi7);
        masterArrayList.add(kurssi8);
        masterArrayList.add(kurssi9);
        masterArrayList.add(kurssi10);
        masterArrayList.add(kurssi11);
        
        student.setDegreeTitle(0, "Bachelor of science");
        student.setDegreeTitle(1, "Master of science");
        student.setTitleOfThesis(0, "Bachelor thesis title");
        student.setTitleOfThesis(1, "Masters thesis title");
        student.addCourses(0, bachelorArrayList);
        student.addCourses(1, masterArrayList);
        student.setStartYear(2001);
        student.setGraduationYear(2020);

      //  System.out.println(student.toString());

        student.setBirthDate("230498-045T");
        student.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        student.setTitleOfThesis(1, "Dreaming of a white christmas");
        //kurssi9.setGrade(3);
        student.setGraduationYear(2020);
       // System.out.println(student.toString());
       // student.printDegrees();
       // student.printCourses();

        //System.out.println(course1.toString());
        //System.out.println(kurssi1.toString());

        Degree degree = new Degree();
        degree.addStudentCourses(bachelorArrayList);
        student.setStartYear(2012);
        student.setGraduationYear(2012);
        System.out.println(student.getStartYear());
        System.out.println(student.getStudyYears());
        degree.addStudentCourses(masterArrayList);
      //System.out.println(degree.getGPA(2));
      //student.printCourses();
      
      //System.out.println(degree.toString());
       // System.out.println(degree.toString());
       // degree.getCredits();
       // degree.getCreditsByType(0);
        //degree.printCourses();
        //degree.getCreditsByBase('x');
        //System.out.println(degree.getGPA(1));
        //System.out.println(degree.getGPA(0));
       //student.printDegrees();
        //student.addCourses(0, bachelorArrayList);
       //System.out.println(student.getIdString());
       // System.out.println(student.toString());
       // student.printDegrees();
       // System.out.println(student.toString());

    }
}

