package com.junioryazilim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@Column(name="personId")
	private int personId;
	@Column(name="personName")
	private String personName;
	@Column(name="personSurname")
	private String personSurname;
	public Person(int personId, String personName, String personSurname) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
	}
	public Person() {
		super();
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSurname() {
		return personSurname;
	}
	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}
	
	
	
	
	
}
