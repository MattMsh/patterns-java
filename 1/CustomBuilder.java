public class CustomBuilder extends AppointmentBuilder {
  @Override
  public void buildAppointment() {
    appointment = new CustomAppointment();
  }
}