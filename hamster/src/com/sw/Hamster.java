package com.sw;

import java.io.Serializable;

public class Hamster implements Serializable {
	private String no;
	private String name;
	private String species;
	private String birth_date;
	private int age;

	public Hamster(String no, String name, String species, String birth_date, int age) {
		this.no = no;
		this.name = name;
		this.species = species;
		this.birth_date = birth_date;
		this.age = age;
	}
	
	public Hamster() {

	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNo() {
		return this.no;
	}

	public String getName() {
		return this.name;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

}
