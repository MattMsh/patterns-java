import java.util.Date;

public class CustomAppointment extends Appointment {
    private String flag;

    public CustomAppointment() {
        this.flag = "red";
    }

    @Override
    public String toString() {
        return super.toString() +
                System.getProperty("line.separator") +
                "  Flag: " + flag;
    }
}