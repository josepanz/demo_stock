package com.developers.demo_stock.service;



import java.util.Optional;


import com.developers.demo_stock.entity.Country;

public interface CountryService  {
	
public Iterable<Country> getAllCountry();

public void save(Country country);

public void delete(Integer id);

Optional<Country> findById(Integer id);

public Country updateCountry(Country country);

public Country getCountryById(Integer id);


}
