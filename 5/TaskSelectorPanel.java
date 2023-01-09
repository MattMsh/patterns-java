import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class TaskSelectorPanel extends JPanel implements ActionListener, TaskChangeObserver {
    private JComboBox<Task> selector = new JComboBox<Task>();

    private TaskChangeObservable notifier;

    public TaskSelectorPanel(TaskChangeObservable newNotifier) {
        notifier = newNotifier;
        createGui();
    }

    public void createGui() {
        selector.addActionListener(this);
        add(selector);
    }

    public void actionPerformed(ActionEvent evt) {
        notifier.selectTask(
                selector.getItemAt(
                        selector.getSelectedIndex()));
    }

    public void setTaskChangeObservable(TaskChangeObservable newNotifier) {
        notifier = newNotifier;
    }

    public void taskAdded(Task task) {
        selector.addItem(task);
    }

    public void taskChanged(Task task) {
    }

    public void taskSelected(Task task) {
    }
}