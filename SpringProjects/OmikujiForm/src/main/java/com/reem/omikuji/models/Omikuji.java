package com.reem.omikuji.models;

public class Omikuji {
	 private Integer number;
	 private String city;
	 private String person;
	 private String hobby;
	 private String thing;
	 private String comment;
	public Omikuji(Integer number, String city, String person, String hobby, String thing, String comment) {
		super();
		this.number = number;
		this.city = city;
		this.person = person;
		this.hobby = hobby;
		this.thing = thing;
		this.comment = comment;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
