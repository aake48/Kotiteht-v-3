public class HourBasedPayment implements Payment{
    
    //Attributes
    
    private double eurosPerHour;
    private double hours;
    
    //Methods

    public double getEurosPerHour() {
        return eurosPerHour;
    }

    public void setEurosPerHour(double eurosPerHour) {
        if (eurosPerHour > 0.0){
        this.eurosPerHour = eurosPerHour;
        }
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours > 0.0){
        this.hours = hours;
        }
    }

    public double calculatePayment(){
        double payment = 0.0;
        payment = eurosPerHour * hours;
        return payment;

    }
}
