
package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    // Creates a fresh contact service and contact before each test.
    @BeforeEach
    void setUp() {
        service = new ContactService();

        contact = new Contact(
                "12345",
                "Kathy",
                "Lopez",
                "7145551234",
                "123 Main Street");
    }

    // Verifies that a contact with a unique ID can be added.
    @Test
    void testAddContact() {
        service.addContact(contact);

        assertSame(contact, service.getContact("12345"));
    }

    // Verifies that duplicate contact IDs are rejected.
    @Test
    void testDuplicateContactId() {
        service.addContact(contact);

        Contact duplicate = new Contact(
                "12345",
                "Maria",
                "Garcia",
                "7145555678",
                "456 Oak Street");

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addContact(duplicate));
    }

    // Verifies that a null contact is rejected.
    @Test
    void testAddNullContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addContact(null));
    }

    // Verifies that a contact can be deleted by contact ID.
    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    // Verifies that deleting a nonexistent contact is rejected.
    @Test
    void testDeleteNonexistentContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.deleteContact("99999"));
    }

    // Verifies that all editable contact fields can be updated.
    @Test
    void testUpdateContact() {
        service.addContact(contact);

        service.updateContact(
                "12345",
                "Maria",
                "Garcia",
                "7145559999",
                "456 Oak Street");

        Contact updatedContact = service.getContact("12345");

        assertAll(
                () -> assertEquals("12345", updatedContact.getContactId()),
                () -> assertEquals("Maria", updatedContact.getFirstName()),
                () -> assertEquals("Garcia", updatedContact.getLastName()),
                () -> assertEquals("7145559999", updatedContact.getPhone()),
                () -> assertEquals("456 Oak Street", updatedContact.getAddress()));
    }

    // Verifies that updating a nonexistent contact is rejected.
    @Test
    void testUpdateNonexistentContact() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.updateContact(
                        "99999",
                        "Maria",
                        "Garcia",
                        "7145559999",
                        "456 Oak Street"));
    }

    // Verifies that an invalid update does not modify the contact.
    @Test
    void testInvalidUpdateDoesNotModifyContact() {
        service.addContact(contact);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.updateContact(
                        "12345",
                        "Maria",
                        "Garcia",
                        "123",
                        "456 Oak Street"));

        Contact unchanged = service.getContact("12345");

        assertAll(
                () -> assertSame(contact, unchanged),
                () -> assertEquals("Kathy", unchanged.getFirstName()),
                () -> assertEquals("Lopez", unchanged.getLastName()),
                () -> assertEquals("7145551234", unchanged.getPhone()),
                () -> assertEquals("123 Main Street", unchanged.getAddress()));
    }
}
