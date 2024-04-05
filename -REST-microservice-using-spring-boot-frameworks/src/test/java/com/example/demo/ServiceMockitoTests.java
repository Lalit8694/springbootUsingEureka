package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.JPArepositories.CountryRepository;
import com.example.demo.beans.country;
import com.example.demo.services.countryService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = { ServiceMockitoTests.class })
public class ServiceMockitoTests {

	@Mock
	CountryRepository countryrep;

	@InjectMocks
	countryService CountryService;

	public List<country> mycountries;

	@Test
	@Order(1)
	public void test_getAllCountries() {
		List<country> mycountries = new ArrayList<country>();
		mycountries.add(new country(1, "India", "Delhi"));
		mycountries.add(new country(2, "USA", "Washington"));

		// Mocking
		when(countryrep.findAll()).thenReturn(mycountries);
		assertEquals(2, CountryService.getAllCountries().size());

	}

	@Test
	@Order(2)
	public void test_getCountryByID() {
		List<country> mycountries = new ArrayList<country>();
		mycountries.add(new country(1, "India", "Delhi"));
		mycountries.add(new country(2, "USA", "Washington"));

		int countryID = 1;

		// Mocking
		when(countryrep.findAll()).thenReturn(mycountries);
		assertEquals(countryID, CountryService.getCountrybyId(countryID).getId());
	}

	@Test
	@Order(3)
	public void test_getCountryByName() {
		List<country> mycountries = new ArrayList<country>();
		mycountries.add(new country(1, "India", "Delhi"));
		mycountries.add(new country(2, "USA", "Washington"));

		String countryName = "India";

		// Mocking
		when(countryrep.findAll()).thenReturn(mycountries);
		assertEquals(countryName, CountryService.getCountrybyName(countryName).getCountryName());
	}

	@Test
	@Order(4)
	public void test_addCountry() {
		country Country = new country(3, "Germany", "Berlin");

		when(countryrep.save(Country)).thenReturn(Country);
		assertEquals(Country, CountryService.addCountry(Country));
	}

	@Test
	@Order(5)
	public void test_updateCountry() {
		country Country = new country(3, "Germany", "Berlin");

		when(countryrep.save(Country)).thenReturn(Country);
		assertEquals(Country, CountryService.updateCountry(Country));
	}
}
