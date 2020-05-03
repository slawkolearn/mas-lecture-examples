package mt.mas.inheritance_overlapping1;

import java.time.LocalDate;
import java.util.EnumSet;

enum PersonType {Person, Employee, Student, Pensioner};

/**
 * Implementation of the overlapping inheritance with a flattened hierarchy.
 * @author Mariusz
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	private boolean medicalTest;

	private int number;
	
	// private PersonType personKind = PersonType.Person;

	// We need to use EnumSet rather then PersonType because we would like
	// to have a possibility of storing combinations of the Person, e.g. Employee + Student
	private EnumSet<PersonType> personKind =  EnumSet.of(PersonType.Person);

	/**
	 * Creates a person as a working student.
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param medicalTest
	 * @param number
	 */
	public Person(String firstName, String lastName, LocalDate birthDate, boolean medicalTest, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.medicalTest = medicalTest;
		this.number = number;

		personKind.add(PersonType.Employee);
		personKind.add(PersonType.Student);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean hasMedicalTest() throws Exception {
		if(personKind.contains(PersonType.Employee)) {
			return medicalTest;
		}

		throw new Exception("The person is not an employee!");
	}

	public void setMedicalTest(boolean medicalTest) throws Exception {
		if(personKind.contains(PersonType.Employee)) {
			this.medicalTest = medicalTest;
		}
		else {
			throw new Exception("The person is not an employee!");
		}
	}

	public int getNumber() throws Exception {
		if(personKind.contains(PersonType.Student)) {
			return number;
		}
		throw new Exception("The person is not a student!");
	}

	public void setNumber(int number) throws Exception {
		if(personKind.contains(PersonType.Student)) {
			this.number = number;
		}
		else {
			throw new Exception("The person is not a student!");
		}
	}

	public EnumSet<PersonType> getPersonKind() {
		return personKind;
	}

	private void setPersonKind(EnumSet<PersonType> personKind) {
		this.personKind = personKind;
	}
}
