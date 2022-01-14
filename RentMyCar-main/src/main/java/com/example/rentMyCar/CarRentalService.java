package com.example.rentMyCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarRentalService {
	
	//private List<Vehicule> Vehicules = new ArrayList<Vehicule>();
	private VehiculeRepository vehiculeRepository;
	
	@Autowired
	public CarRentalService(VehiculeRepository vehiculeRepository) {
		this.vehiculeRepository = vehiculeRepository;
		/*Vehicules.add(new Vehicule("11AA22", "Ferrari", 1000));
		Vehicules.add(new Vehicule("33BB44", "Porshe", 2222));*/
	}
	
	@GetMapping("/Vehicules")
	
	@ResponseBody
	public Iterable<Vehicule> getListOfVehicules(){
		return vehiculeRepository.findAll();
		}
	
 
	@PostMapping("/Vehicules")
	public void addVehicule(@RequestBody Vehicule Vehicule) throws Exception{
		System.out.println(Vehicule);
		vehiculeRepository.save(Vehicule);
	}

	@GetMapping("/Vehicules/{plateNumber}")
	public Vehicule getVehicule(@PathVariable(value = "plateNumber") String plateNumber){
		return vehiculeRepository.findById(plateNumber).get();
	}

	@PutMapping(value = "/Vehicules/{plateNumber}")
	public void rent(@PathVariable("plateNumber") String plaque,
					 @RequestParam(value="rent", required = true)boolean rented,
					 @RequestBody(required = false) Dates dates){
		System.out.println(plaque);
		System.out.println(rented);
		System.out.println(dates);
		
			if(vehiculeRepository.findById(plaque) != null){
				Vehicule vehicule = vehiculeRepository.findById(plaque).get();			
					if(vehicule.isRented()==false) {
						vehicule.setRented(rented);
						vehicule.setDates(dates);
					}				
			} 		 
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Il n'y a pas de voiture avec ce matricule");
		 
	
	} 
	
	

}
