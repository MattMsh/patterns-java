import java.util.ArrayList;

public class ContactMediatorImpl implements ContactMediator {
    private ContactDisplayPanel display;
    private ContactEditorPanel editor;
    private ContactSelectorPanel selector;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private int contactIndex;

    public void setContactDisplayPanel(ContactDisplayPanel displayPanel) {
        display = displayPanel;
    }

    public void setContactEditorPanel(ContactEditorPanel editorPanel) {
        editor = editorPanel;
    }

    public void setContactSelectorPanel(ContactSelectorPanel selectorPanel) {
        selector = selectorPanel;
    }

    public void createContact(String firstName, String lastName, String title, String organization) {
        Contact newContact = new ContactImpl(firstName, lastName, title, organization);
        addContact(newContact);
        selector.addContact(newContact);
        display.contactChanged(newContact);
    }

    public void updateContact(String firstName, String lastName, String title, String organization) {
        Contact updateContact = contacts.get(contactIndex);
        if (updateContact != null) {
            updateContact.setFirstName(firstName);
            updateContact.setLastName(lastName);
            updateContact.setTitle(title);
            updateContact.setOrganization(organization);
            display.contactChanged(updateContact);
        }
    }

    public void deleteContact() {
        contacts.remove(contactIndex);
        selector.removeContact();
        if (contactIndex > 0) {
            contactIndex--;
        } else {
            if (contacts.size() > 1) {
                contactIndex++;
            }
        }

    }

    public void selectContact(Contact contact) {
        if (contacts.contains(contact)) {
            contactIndex = contacts.indexOf(contact);
            display.contactChanged(contact);
            editor.setContactFields(contact);
        }
    }

    public Contact[] getAllContacts() {
        return contacts.toArray(new Contact[1]);
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }
}