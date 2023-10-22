package com.asr.location.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asr.location.web.model.Location;
import com.asr.location.web.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@PostMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.saveLocation(location);
		String message = "Location saved successfully";
		modelMap.addAttribute("msg", message);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<Location> allSavedLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allSavedLocations);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location locationToDelete = service.getLocationById(id);
		service.deleteLocation(locationToDelete);
		List<Location> allLocationsAfterDeletionOfLocation = service.getAllLocations();
		modelMap.addAttribute("locations", allLocationsAfterDeletionOfLocation);
		return "displayLocation";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

}
