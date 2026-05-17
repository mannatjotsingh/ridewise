package com.example.airtribe.rideshare.model;

public class Rider {
	private int id;
	private String name;
	private int location;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
//	public void setId(int id) {
//		this.id = id;
//	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	 public Rider(int id, String name, int location) {
	        this.id = id;
	        this.name = name;
	        this.location = location;
	    }
	 @Override
	    public String toString() {
	        return "Rider{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", location=" + location +
	                '}';
	    }	
	
}
