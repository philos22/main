package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Role role;

    private final UniqueTagList tags;

    private boolean isInCell = false;
    /**
     * Every field must be present and not null.
     */
    /*
    public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = new Role("p");
        // protect internal tags from changes in the arg list
        this.tags = new UniqueTagList(tags);
    }
    */

    /**
     * New Constructor for working
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Role role, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        // protect internal tags from changes in the arg list
        this.tags = new UniqueTagList(tags);
    }

    /**
     * Constructor for updatedPrisoner after being added to cell
     * @param person is prisoner being added to cell
     * @param isInCell is true if adding to cell
     * @param cellAddress
     */
    public Person (Person person, boolean isInCell, String cellAddress) {
        requireAllNonNull(person, isInCell);
        this.name = person.getName();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.address = new Address(cellAddress + "[imprisoned]");
        this.role = person.getRole();
        this.tags = new UniqueTagList(person.getTags());
        this.isInCell = isInCell;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags.toSet());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(this.getName())
                && otherPerson.getPhone().equals(this.getPhone())
                && otherPerson.getEmail().equals(this.getEmail())
                && otherPerson.getAddress().equals(this.getAddress())
                && otherPerson.getRole().equals(this.getRole());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Role: ")
                .append(getRole())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
