import java.time.*;
public abstract class Employee extends Person implements Payment {
    
    //Attributes

    private String empId = "OY_";
    private int startYear = Year.now().getValue();
    private Payment payment; // HOUR BASED OR MONTHLY BASED

    //Constructor

    public Employee (String lname, String fname){
        super(lname, fname);
        this.empId = getEmployeeIdString() + super.getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
    }

    //Methods

    public String getIdString(){
        return empId;
    }

    public int getStartYear(){
        return startYear;
    }

    public void setStartYear(final int startYear){
        if (startYear > 2000 && startYear <= Year.now().getValue()){
            this.startYear = startYear;
        }
    }

    public Payment getPayment(){
        return payment;
    }

    public void setPayment (Payment payment){
        if (payment != null){
            this.payment = payment;
        }
    }

    public double calculatePayment(){

        double pay = 0.0;
        if (payment != null){
          pay = payment.calculatePayment();
            return pay;
        }else{
        return 0.0;
        }

    }

    protected abstract String getEmployeeIdString();
}

