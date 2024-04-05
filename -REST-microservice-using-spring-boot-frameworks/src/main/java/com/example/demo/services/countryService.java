package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.JPArepositories.CountryRepository;
import com.example.demo.beans.country;
import com.example.demo.controllers.AddResponse;

@Component
@Service
public class countryService {

	@Autowired
	CountryRepository contryrep;

	public List<country> getAllCountries() {
		List<country> countries = contryrep.findAll();
		return countries;
	}

	public country getCountrybyId(int id) {
		List<country> countries = contryrep.findAll();
		country Country = null;
		for (country con : countries) {
			if (con.getId() == id)
				Country = con;
		}
		return Country;
		// return contryrep.findById(id).get();
	}

	public country getCountrybyName(String countryName) {
		List<country> countries = contryrep.findAll();
		country Country = null;

		for (country con : countries) {
			if (con.getCountryName().equalsIgnoreCase(countryName))
				Country = con;
		}

		return Country;

	}

	public country addCountry(country Country) {
		Country.setId(getMaxId());
		contryrep.save(Country);
		return Country;
	}

	// Utility method for getting max id
	public int getMaxId() {
		return contryrep.findAll().size() + 1;
	}

	public country updateCountry(country Country) {
		contryrep.save(Country);
		return Country;
	}

	public AddResponse deleteCountry(int id) {
		contryrep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country is deleted..");
		res.setId(id);
		return res;
	}

}
