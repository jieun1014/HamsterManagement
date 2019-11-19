package com.hamster.hamster;

import java.io.Serializable;

public class Hamster implements Serializable {

	private int no;
	private String name;
	private String gender;
	private String species;
	private String birth_date;
	private String color;
	private String status;
	
	public Hamster() {
		
	}
	
	public Hamster(int no, String name, String gender, String species, String birth_date, String color, String status) {
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.species = species;
		this.birth_date = birth_date;
		this.color = color;
		this.status = status;
	}
	
	public Hamster( String name, String gender, String species, String birth_date, String color, String status) {
		this.name = name;
		this.gender = gender;
		this.species = species;
		this.birth_date = birth_date;
		this.color = color;
		this.status = status;
	}
	
	public Hamster(int no, String name, String species) {
		this.no = no;
		this.name = name;
		this.species = species;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
