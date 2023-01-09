import java.util.ArrayList;

public class ChangeLocationCommand implements UndoableCommand {
    private Appointment appointment;
    private ArrayList<Location> history = new ArrayList<Location>();
    private int currentLocationIndex = 0;
    private LocationEditor editor;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setLocationEditor(LocationEditor locationEditor) {
        editor = locationEditor;
    }

    public void execute() {
        history.add(editor.getNewLocation());
        currentLocationIndex = history.size() - 1;
        appointment.setLocation(history.get(currentLocationIndex));
    }

    public void undo() {
        if (currentLocationIndex - 1 >= 0) {
            currentLocationIndex--;
        }
        appointment.setLocation(history.get(currentLocationIndex));
    }

    public void redo() {
        if (currentLocationIndex < history.size() - 1) {
            currentLocationIndex++;
        }
        appointment.setLocation(history.get(currentLocationIndex));
    }
}