package com.lulimi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lulimi.model.Locality;
import com.lulimi.service.LocalityService;

@RestController
public class LocalityController {

	@Autowired
	LocalityService localityService;
	
	@RequestMapping(value = "/locality/", method = RequestMethod.GET)
	public ResponseEntity<List<Locality>> listAllLocalities()
	{
		List<Locality> localities = localityService.findAll();
		if(localities.isEmpty())
		{
			return new ResponseEntity<List<Locality>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Locality>>(localities, HttpStatus.OK);
	}
	
	@RequestMapping(value="/locality/{country}", method=RequestMethod.GET)
	public ResponseEntity<Locality> getLocality(@PathVariable("country") String country)
	{
		Locality locality = localityService.findOne(country);
		if(locality == null)
		{
			return new ResponseEntity<Locality>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Locality>(locality, HttpStatus.OK);
	}
	
	@RequestMapping(value="/locality/", method=RequestMethod.POST)
	public ResponseEntity<Void> createLocality(@RequestBody Locality locality, UriComponentsBuilder ucBuilder)
	{
		if(localityService.findOne(locality.getCountry()) != null)
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		localityService.save(locality);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/locality/{country}").buildAndExpand(locality.getCountry()).toUri());
		//TODO - check if this id thing picks up correctly, not sure for now
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/locality/{country}", method=RequestMethod.PUT)
	public ResponseEntity<Locality> updateLocality(@PathVariable("country") String country, @RequestBody Locality locality )
	{	
		Locality currentLocality = localityService.findOne(country);
		if(currentLocality == null)
		{
            return new ResponseEntity<Locality>(HttpStatus.NOT_FOUND);
		}
		if(locality.getCountry().trim() != null){
			currentLocality.setCountry(locality.getCountry().trim());
		}
		if(locality.getLanguages().size() > 0){
			//avoid duplicates while adding new ones
			Set<String> set = new HashSet<String>(currentLocality.getLanguages());
			for(String language : locality.getLanguages()){
				set.add(language);
			}
			currentLocality.setLanguages(new ArrayList<String>(set));
		}
		
		localityService.save(currentLocality);
		//TODO - more tests needed to prove this updates correctly
        return new ResponseEntity<Locality>(currentLocality, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/locality/{country}", method = RequestMethod.DELETE)
    public ResponseEntity<Locality> deleteLocality(@PathVariable("country") String country) {
 
        if (localityService.findOne(country) == null) {
            return new ResponseEntity<Locality>(HttpStatus.NOT_FOUND);
        }
 
        localityService.delete(country);
        return new ResponseEntity<Locality>(HttpStatus.NO_CONTENT);
    }
	
}
