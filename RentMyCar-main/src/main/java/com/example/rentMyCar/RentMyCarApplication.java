package com.example.rentMyCar;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentMyCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentMyCarApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository,DatesRepository datesRepository) {
		return (args) -> {
			Person tintin = new Person();
			tintin.setAge(20);
			tintin.setNom("Tintin");
			
			Person kamy = new Person();
			kamy.setAge(23);
			kamy.setNom("Kamy");
			
			 String pattern = "yyyy-MM-dd";
		     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		     Date date_debut = simpleDateFormat.parse("2018-09-09");
		     Date date_fin = simpleDateFormat.parse("2018-09-12");
		     
		     Date date_debut_2 = simpleDateFormat.parse("2020-09-02");
		     Date date_fin_2 = simpleDateFormat.parse("2021-12-01");
			    
			Dates date=new Dates();		
			date.setBegin(date_debut);
			date.setEnd(date_fin);
		
			Dates date_2=new Dates();
			date_2.setBegin(date_debut_2);
			date_2.setEnd(date_fin_2);
			
		
			Van van_1 = new Van();
			van_1.setPlateNumber("45B23");
			van_1.setRented(false);
			van_1.setBrand("BMW");
			van_1.setPrice(2313132);
			van_1.setMaxWeight(400);
			
			Car car_1 = new Car();
			car_1.setPlateNumber("89A32");
			car_1.setRented(false);
			car_1.setBrand("Renault");
			car_1.setPrice(23400);
			car_1.setnumberOfSeats(4);
			
			kamy.addDates(date);
			tintin.addDates(date_2);
		 
			
			van_1.setDates(date_2);
			car_1.setDates(date);
			
		
			date.setPerson(kamy);
			date_2.setPerson(tintin);
			
			date_2.setVehicule(van_1);
			
			date.setVehicule(car_1);
		
			datesRepository.save(date);
			datesRepository.save(date_2);

		};
	}
	


}