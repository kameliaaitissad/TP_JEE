package com.example.rentMyCar;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dates {

	long id;
    Date begin;
    Date end;
    Vehicule vehicule;
    Person person;
    
 
    @OneToOne
    @JsonIgnore
    public Vehicule getVehicule() {
    	return vehicule;
    }
    
    public void setVehicule(Vehicule Vehicule) {
    	this.vehicule = Vehicule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
     	return id; }
    
    public void setId(long id) {
     	this.id = id; }
    
    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date date_debut) {
        this.begin = date_debut;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    
    
    public void setPerson(Person person) {
    	this.person = person;
    }
    
    @ManyToOne(cascade=CascadeType.ALL)
    public Person getPerson() {
    	return person;
    }
	
	
    @Override
    public String toString() {
        return "Dates[" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                "]\n";
    }
}
