package com.example.rentMyCar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarRentalService {
	
	private List<Vehicule> Vehicules = new ArrayList<Vehicule>();
	
	public CarRentalService() {
		Vehicules.add(new Vehicule("11AA22", "Ferrari", 1000));
		Vehicules.add(new Vehicule("33BB44", "Porshe", 2222));
	}
	
	@GetMapping("/Vehicules")
	public List<Vehicule> getListOfVehicules(){
		return Vehicules;
	}
	
	@PostMapping("/Vehicules")
	public void addVehicule(@RequestBody Vehicule Vehicule) throws Exception{
		System.out.println(Vehicule);
		Vehicules.add(Vehicule);
	}

	@GetMapping("/Vehicules/{plateNumber}")
	public Vehicule getVehicule(@PathVariable(value = "plateNumber") String plateNumber){
		for(Vehicule Vehicule: Vehicules){
			if(Vehicule.getPlateNumber().equals(plateNumber)){
				return Vehicule;
			}
		}
		return null;
	}

	@PutMapping(value = "/Vehicules/{plateNumber}")
	public void rent(@PathVariable("plateNumber") String plaque,
					 @RequestParam(value="rent", required = true)boolean rented,
					 @RequestBody(required = false) Dates dates){
		System.out.println(plaque);
		System.out.println(rented);
		System.out.println(dates);
		
		for(Vehicule Vehicule: Vehicules){
			if(Vehicule.getPlateNumber().equals(plaque)){
				if(Vehicule.isRented()==false) {
					Vehicule.setRented(rented);
					Vehicule.setDates(dates);
					
				}
				return;
			} 		 
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
		 
	
	}

}
