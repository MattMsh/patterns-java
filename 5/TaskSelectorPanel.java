import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class TaskSelectorPanel extends JPanel implements ActionListener, TaskChangeObserver {
    private JComboBox<Task> selector = new JComboBox<Task>();
    private JRadioButton changeNametypeRadio = new JRadioButton("Show only Notes", null, false);

    private TaskChangeObservable notifier;

    public TaskSelectorPanel(TaskChangeObservable newNotifier) {
        notifier = newNotifier;
        createGui();
    }

    public void createGui() {
        selector.addActionListener(this);
        changeNametypeRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean isNotes = changeNametypeRadio.isSelected();
                int size = selector.getItemCount();
                for (int i = 0; i < size; i++) {
                    Task task = selector.getItemAt(i);
                    task.setIsNotes(isNotes);
                }
                selector.revalidate();
                selector.repaint();
            }
        });
        add(selector);
        add(changeNametypeRadio);
    }

    public void actionPerformed(ActionEvent e) {
        Task selectedTask = selector.getItemAt(selector.getSelectedIndex());
        notifier.selectTask(selectedTask);
    }

    public void setTaskChangeObservable(TaskChangeObservable newNotifier) {
        notifier = newNotifier;
    }

    public void taskAdded(Task task) {
        task.setIsNotes(changeNametypeRadio.isSelected());
        selector.addItem(task);
    }

    public void taskChanged(Task task) {
    }

    public void taskSelected(Task task) {
    }
}