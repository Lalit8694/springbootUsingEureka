package com.example.demo.JPArepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.country;

public interface CountryRepository extends JpaRepository<country, Integer> {

}
