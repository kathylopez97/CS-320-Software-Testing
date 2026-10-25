# CS-320: Software Testing, Automation, and Quality Assurance

## Portfolio Reflection

This repository contains my Contact Service files from Project One and my Summary and Reflections Report from Project Two. Throughout CS-320, I worked with Java and JUnit to test the Contact, Task, and Appointment services. Before this course, I mostly focused on getting my code to run. I learned that a program can appear to work correctly while still having problems that aren't easy to notice. These projects helped me become more careful about testing, following requirements, and handling errors.

### How can I ensure that my code, program, or software is functional and secure?

I can make my software more reliable and secure by checking how it handles different inputs, reviewing my code, and testing situations where something might go wrong. In Project One, I used JUnit to test invalid phone numbers, duplicate contact IDs, and attempts to update or delete records that didn't exist. I also checked that failed updates wouldn't change information already stored in the program.

One thing I learned was that catching an error isn't enough if the program has already changed something it shouldn't have. I also realized that passing every test doesn't mean I've found every possible problem. To improve security, I would need to consider who can access or change information and how sensitive data is protected. In future projects, I plan to keep testing after making changes and pay closer attention to problems I might have missed.

### How do I interpret user needs and incorporate them into a program?

Understanding user needs means figuring out what the program should do and how it should respond to different situations. For the Contact Service, I followed specific requirements for names, phone numbers, addresses, and contact IDs. Phone numbers had to contain exactly 10 digits, while contact IDs couldn't exceed 10 characters.

I used these rules to decide how the program should work and what needed to be tested. For example, it wasn't enough to check whether a contact could be added successfully. I also needed to make sure incorrect information was rejected. Working through these situations helped me understand why small details in the requirements matter. If I overlook one of those details, the program might not behave the way users expect.

### How do I approach designing software?

When designing software, I find it helpful to break the program into smaller parts and give each part a clear purpose. In Project One, I kept the Contact class separate from ContactService. The Contact class handled contact information and validation, while ContactService managed adding, updating, deleting, and retrieving records. This made it easier to understand how the program worked and where each operation belonged.

I also learned that the order of operations matters. When updating a contact, I validated the new information before replacing the existing record. That way, an invalid update wouldn't change information that was already correct.

Looking back, my approach to programming has changed. I used to concentrate on finishing the code and making sure it ran. Now I think more about how the different parts work together, what could go wrong, and whether the program will be easy to maintain. These are things I want to keep improving as I work on future projects.
