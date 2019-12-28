package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	//inyeccion de dependecia
	
	/*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
	
	@Autowired
	CountryRepository countryRepo;
	
	/*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
	@Override
	@Transactional(readOnly = true)
	public Iterable<Country> getAllCountry() {
		return countryRepo.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		countryRepo.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(Country country) {
		countryRepo.save(country);
		
	}

	@Override
	public Optional<Country> findById(Integer id) {	
		return countryRepo.findById(id);
	}

	@Override
	@Transactional
	public Country updateCountry(Country fromCountry) {
		Country toCountry = getCountryById(fromCountry.getId());
		mapCountry(fromCountry, toCountry);
		return countryRepo.save(toCountry);
	
		//return null;
	}
	
	protected void mapCountry(Country from,Country to) {
		to.setCode(from.getCode());
		to.setDescription(from.getCode());

	}

	@Override
	public Country getCountryById(Integer id)  {	
			Optional<Country> optionalCountry = countryRepo.findById(id);
		      return optionalCountry.get();
	}

	



 

}
