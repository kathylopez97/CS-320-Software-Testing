package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

	// Stores contacts in memory.
	private final List<Contact> contacts = new ArrayList<>();

	// Adds a contact only if the contact ID is unique.
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null.");
		}

		if (findContact(contact.getContactId()) != null) {
			throw new IllegalArgumentException("Contact ID must be unique.");
		}

		contacts.add(contact);
	}

// Deletes a contact using the contact ID.
	public void deleteContact(String contactId) {
		Contact contact = findContact(contactId);

		if (contact == null) {
			throw new IllegalArgumentException("Contact not found.");
		}

		contacts.remove(contact);
	}

// Updates the editable fields for an existing contact.

	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {

		Contact existingContact = findContact(contactId);

		if (existingContact == null) {
			throw new IllegalArgumentException("Contact not found.");
		}

		// Validate all fields by creating a replacement contact.
		Contact updatedContact = new Contact(contactId, firstName, lastName, phone, address);

		// Replace the contact only after validation succeeds.
		int index = contacts.indexOf(existingContact);
		contacts.set(index, updatedContact);
	}

// Returns a contact that matches the specified ID.
	public Contact getContact(String contactId) {
		return findContact(contactId);
	}

// Searches the contact list for a matching contact ID.
	private Contact findContact(String contactId) {
		for (Contact contact : contacts) {
			if (contact.getContactId().equals(contactId)) {
				return contact;
			}
		}

		return null;
	}
}
