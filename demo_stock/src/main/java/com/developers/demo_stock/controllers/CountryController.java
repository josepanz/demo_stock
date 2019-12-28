package com.developers.demo_stock.controllers;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping("/country")
	public String city(Model model) {
		model.addAttribute("countryList", countryService.getAllCountry());
		/* para poner titulo pag. web titulo(se encuentra en el layout) */
		model.addAttribute("title", "País");
		return "country/country";
	}

	@GetMapping("/addCountry")
	public String getCountry(Map<String, Object> model) {
		Country country = new Country();
		/* formulario objeto de country */
		model.put("country", country);
		/* para poner titulo pag. web titulo(se encuentra en el layout) */
		model.put("title", "Agregar Pais");
		return "country/addCountry";
	}

	@PostMapping("/addCountry")
	public String postCountry(@Valid @ModelAttribute("country") Country country, BindingResult result, Model model,
			SessionStatus status) {
		model.addAttribute("title", "Agregar País");
		if (result.hasErrors()) {
			return "country/addCountry";
		}
		try {

			countryService.save(country);
			status.setComplete();
			model.addAttribute("success", "Pais agregado con éxito!");
			model.addAttribute("country", new Country());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "country/addCountry";
	}

	@GetMapping("/editCountry/{id}")
	public String getEditCountry(@PathVariable(value = "id") Integer id, Model model) {
		model.addAttribute("country", countryService.findById(id));
		model.addAttribute("title", "Editar Pais");
		return "country/editCountry";
	}

	@PostMapping("/editCountry")
	public String putEditCountry(@Valid @ModelAttribute("country") Country country, BindingResult result, Model model,
			SessionStatus status, RedirectAttributes flash) {
		model.addAttribute("title", "Editar País");
		if (result.hasErrors()) {
			return "country/editCountry";
		}						
		try {
		
			//countryService.save(country);
			countryService.updateCountry(country);
			status.setComplete();
			flash.addFlashAttribute("success", "Pais editado con éxito!");
	

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "redirect:/country";
	}

	@GetMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
		try {
			countryService.delete(id);
			flash.addFlashAttribute("success", "Pais eliminado con éxito!");
		} catch (Exception e) {
			flash.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/country";
	}

}
