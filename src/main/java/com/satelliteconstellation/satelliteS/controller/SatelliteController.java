package com.satelliteconstellation.satelliteS.controller;

import java.util.Optional;

import com.satelliteconstellation.satelliteS.exceptions.InvalidSatelliteReferenceException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satelliteconstellation.satelliteS.VO.ResponseTemplate;
import com.satelliteconstellation.satelliteS.entity.Satellite;
import com.satelliteconstellation.satelliteS.service.SatelliteService;

@RestController
@RequestMapping("/satellite")
public class SatelliteController {
	
    @Autowired
    SatelliteService satelliteService;

    @PostMapping("/create")
    public Long createSatellite(@RequestBody Satellite satellite) {
        satelliteService.saveSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @GetMapping("/viewAll")
    public Iterable<Satellite> viewAllSatellites() {
        return satelliteService.getSatelliteHistory();
    }

    @GetMapping("/view/{id}")
    public Satellite viewSatelliteById(@PathVariable ("id") Long id) {
        Optional<Satellite> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satellite.get();
        }else {

        throw new InvalidSatelliteReferenceException("Invalid Satellite reference provided");
        }
    }

    @PutMapping("/update")
    public Long updateSatellite(@RequestBody Satellite satellite) {
        satelliteService.updateSatellite(satellite);
        return satellite.getSatelliteId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSatellite(@PathVariable ("id") long id) {
        Optional<Satellite> satellite = satelliteService.getSatellite(id);
        if(satellite.isPresent()) {
            return satelliteService.deleteSatellite(id);
        }else {

        throw new InvalidSatelliteReferenceException("Invalid Satellite reference provided");
        }
        
    }
        @GetMapping("/location/{id}")
        public ResponseTemplate getSatelliteWithLocation(@PathVariable("id") long id) {
        	return satelliteService.getSatelliteWithLocation(id);
        }
   
    
    

}
