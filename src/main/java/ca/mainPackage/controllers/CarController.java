package ca.mainPackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.mainPackage.beans.Car;
import ca.mainPackage.database.CarAccess;

@Controller
public class CarController {
	
	@Autowired
	private CarAccess da;
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("car", new Car());
		return "home.html";
	}
	
	@GetMapping("/goAddCar")
	public String goAddCar(Model model) {
		model.addAttribute("car", new Car());
		return "addCar.html";
	}
	
	@GetMapping("/addCar")
	public String addCar(Model model, @ModelAttribute Car car) {
		da.addCar(car); 
		model.addAttribute("car", new Car());
		return "addCar.html";
	}
	
	@GetMapping("/view")
	public String viewCars(Model model) {
		model.addAttribute("car", da.getCars()); 
		return "viewCar.html";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editCar(Model model, @PathVariable int id) {
		Car car = da.getCarById(id);
		model.addAttribute("car", car);
		return "editCar.html";
	}
	
	@GetMapping ("/delete/{id}")
	public String deleteCar(Model model, @PathVariable int id) {
		da.deleteCar(id);
		
		model.addAttribute("car", da.getCarById(id));
		return "redirect:/view";
	}
	
	@GetMapping("/editCar")
	public String editCar(Model model, @ModelAttribute Car car) {
		da.editCar(car);
		return "redirect:/view";
	}
	
	@GetMapping("/searchCar")
	public String searchCar(Model model) {
		model.addAttribute("car", new Car()); 
		return "searchCar.html";
		
	}
	
	@GetMapping("/searchCarID")
	public String searchCarID(Model model, @RequestParam int id) {
		Car car = da.getCarById(id);
		model.addAttribute("car", car); 
		return "viewCar.html";
		
	}
	
	@GetMapping("/searchCarMake")
	public String searchCarMake(Model model, @RequestParam String make) {
		model.addAttribute("car", da.getCarByMake(make)); 
		return "viewCar.html";
		
	}
	
	@GetMapping("/searchCarModel")
	public String searchCarModel(Model model, @RequestParam String carModel) {
		model.addAttribute("car", da.getCarByModel(carModel)); 
		return "viewCar.html";
		
	}
	
	@GetMapping("/searchCarPrice")
	public String searchCarPrice(Model model, @RequestParam double min, @RequestParam double max) {
		model.addAttribute("car", da.getCarByPrice(min,max)); 
		return "viewCar.html";
		
	}
	
	@GetMapping ("/purchase/{id}")
	public String purchaseCar(Model model, @PathVariable int id) {
		Car car = da.getCarById(id);
		model.addAttribute("car", car); 
		da.deleteCar(id);
		return "purchaseCar.html";
	}

}
