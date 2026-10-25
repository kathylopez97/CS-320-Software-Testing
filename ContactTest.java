
package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Valid contact information used throughout the tests.
    private static final String VALID_ID = "12345";
    private static final String VALID_FIRST_NAME = "Kathy";
    private static final String VALID_LAST_NAME = "Lopez";
    private static final String VALID_PHONE = "7145551234";
    private static final String VALID_ADDRESS = "123 Main Street";

    // Verifies that a contact can be created with valid information.
    @Test
    void testValidContact() {
        Contact contact = createValidContact();

        assertAll(
                () -> assertEquals(VALID_ID, contact.getContactId()),
                () -> assertEquals(VALID_FIRST_NAME, contact.getFirstName()),
                () -> assertEquals(VALID_LAST_NAME, contact.getLastName()),
                () -> assertEquals(VALID_PHONE, contact.getPhone()),
                () -> assertEquals(VALID_ADDRESS, contact.getAddress()));
    }

    // Verifies that invalid contact IDs are rejected.
    @Test
    void testInvalidContactId() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(null, VALID_FIRST_NAME,
                                VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact("12345678901", VALID_FIRST_NAME,
                                VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS)));
    }

    // Verifies that invalid first and last names are rejected.
    @Test
    void testInvalidNames() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, null,
                                VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, "LongFirstName",
                                VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                null, VALID_PHONE, VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                "LongLastName", VALID_PHONE, VALID_ADDRESS)));
    }

    // Verifies that invalid phone numbers are rejected.
    @Test
    void testInvalidPhone() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                VALID_LAST_NAME, null, VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                VALID_LAST_NAME, "714555123", VALID_ADDRESS)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                VALID_LAST_NAME, "71455ABCDE", VALID_ADDRESS)));
    }

    // Verifies that invalid addresses are rejected.
    @Test
    void testInvalidAddress() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                VALID_LAST_NAME, VALID_PHONE, null)),

                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(VALID_ID, VALID_FIRST_NAME,
                                VALID_LAST_NAME, VALID_PHONE,
                                "This address is longer than thirty characters")));
    }

    // Verifies that the first name can be updated.
    @Test
    void testSetFirstName() {
        Contact contact = createValidContact();

        contact.setFirstName("Maria");
        assertEquals("Maria", contact.getFirstName());

        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName("LongFirstName"));

        assertEquals("Maria", contact.getFirstName());
    }

    // Verifies that the last name can be updated.
    @Test
    void testSetLastName() {
        Contact contact = createValidContact();

        contact.setLastName("Garcia");
        assertEquals("Garcia", contact.getLastName());

        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName("LongLastName"));

        assertEquals("Garcia", contact.getLastName());
    }

    // Verifies that the phone number can be updated.
    @Test
    void testSetPhone() {
        Contact contact = createValidContact();

        contact.setPhone("7145559999");
        assertEquals("7145559999", contact.getPhone());

        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone("123"));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone("71455ABCDE"));

        assertEquals("7145559999", contact.getPhone());
    }

    // Verifies that the address can be updated.
    @Test
    void testSetAddress() {
        Contact contact = createValidContact();

        contact.setAddress("456 Oak Street");
        assertEquals("456 Oak Street", contact.getAddress());

        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress(
                        "This address is longer than thirty characters"));

        assertEquals("456 Oak Street", contact.getAddress());
    }

    // Creates a valid contact for reuse in the tests.
    private Contact createValidContact() {
        return new Contact(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_PHONE,
                VALID_ADDRESS);
    }
}
