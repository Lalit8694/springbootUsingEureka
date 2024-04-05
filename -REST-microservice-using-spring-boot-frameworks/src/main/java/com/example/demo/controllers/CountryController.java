package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.country;
import com.example.demo.services.countryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "REST microservice using spring boot framework", description = " Class which perform all the task which given in the assignmnet")
public class CountryController {

	@Autowired
	countryService CountryService;

	@GetMapping("/getcountries")
	public List<country> getCounteries() {
		return CountryService.getAllCountries();
	}

	// By Id as mention in the assignment
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<country> getCountryById(@PathVariable(value = "id") int id) {
		try {
			country Country = CountryService.getCountrybyId(id);
			return new ResponseEntity<country>(Country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// By Filter as mention in the assignment
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<country> getCountryByName(@RequestParam(value = "name") String countryName) {
		try {
			country Country = CountryService.getCountrybyName(countryName);
			return new ResponseEntity<country>(Country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addcountry")
	public country addCountry(@RequestBody country Country) {
		return CountryService.addCountry(Country);
	}

	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<country> updateCountry(@PathVariable(value = "id") int id, @RequestBody country Country) {
		try {
			country existCountry = CountryService.getCountrybyId(id);
			existCountry.setCountryName(Country.getCountryName());
			existCountry.setCountryCapital(Country.getCountryCapital());

			country updated_country = CountryService.updateCountry(existCountry);
			return new ResponseEntity<country>(updated_country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

//	@DeleteMapping("/deletecountry")
//	public AddResponse deleteCountry(@PathVariable (value="id") int id) {
//		return CountryService.deleteCountry(id);
//	}

}
