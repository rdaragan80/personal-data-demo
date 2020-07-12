package com.example.personaldata.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "PERSON")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person extends AuditModel{
	private long id;
	private String firstName;
	private String lastName;
	private Set<Address> personAddresses = new HashSet<Address>(0);

	public Person() {
	}

	public Person(String personName, String lastName, Set<Address> personAddresses) {
		this.firstName = personName;
		this.lastName = lastName;
		this.personAddresses = personAddresses;

	}
	
	 public Person(String firstName, String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;
    }

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	public String getFirstName() {
		return this.firstName;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Cacheable
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PERSON_ADDRESS", 
	           joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ADDRESS_ID") })
	public Set<Address> getPersonAddresses() {
		if(null == this.personAddresses) {
			return new HashSet<Address>();
		}
		return this.personAddresses;
	}

	public void setPersonAddresses(Set<Address> personAddresses) {
		this.personAddresses = personAddresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", personAddresses="
				+ personAddresses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((personAddresses == null) ? 0 : personAddresses.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (personAddresses == null) {
			if (other.personAddresses != null)
				return false;
		} else if (!personAddresses.equals(other.personAddresses))
			return false;
		return true;
	}
}
