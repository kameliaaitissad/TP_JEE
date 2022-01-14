package com.example.rentMyCar;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Person {

    String nom;
    int age;
    Collection<Dates> dates=new ArrayList<Dates>();

    
    @Id
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @OneToMany(mappedBy="person")
    @JsonIgnore
   	public Collection<Dates> getDates() {
   		return dates;
   	}
   	
   	public void setDates(Collection<Dates> dates) {
   		this.dates = dates;}
   		
   	public void addDates(Dates dates) {
   		this.getDates().add(dates);	
   		dates.person = this;}
   	
   	
    
    

}