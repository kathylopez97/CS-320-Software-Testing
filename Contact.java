package contact;

public class Contact {

	// Contact ID cannot be changed after the contact is created.
	private final String contactId;

	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Creates a contact and validates all required fields.
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {

		validateContactId(contactId);
		validateName(firstName, "First name");
		validateName(lastName, "Last name");
		validatePhone(phone);
		validateAddress(address);

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Returns contact information.
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	// Updates editable fields after validating the new values.
	public void setFirstName(String firstName) {
		validateName(firstName, "First name");
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		validateName(lastName, "Last name");
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}

	public void setAddress(String address) {
		validateAddress(address);
		this.address = address;
	}

	// Contact ID is required and cannot exceed 10 characters.
	private void validateContactId(String contactId) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Contact ID must be 10 characters or fewer.");
		}
	}

	// First and last names are required and cannot exceed 10 characters.
	private void validateName(String name, String fieldName) {
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException(fieldName + " must be 10 characters or fewer.");
		}
	}

	// Phone number is required and must contain exactly 10 digits.
	private void validatePhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must contain exactly 10 digits.");
		}
	}

	// Address is required and cannot exceed 30 characters.
	private void validateAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address must be 30 characters or fewer.");
		}
	}
}
