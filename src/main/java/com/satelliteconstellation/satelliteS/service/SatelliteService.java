package com.satelliteconstellation.satelliteS.service;

import java.util.Optional;

import com.satelliteconstellation.satelliteS.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satelliteconstellation.satelliteS.VO.Location;
import com.satelliteconstellation.satelliteS.VO.ResponseTemplate;
import com.satelliteconstellation.satelliteS.entity.Satellite;

@Service
public class SatelliteService {

    @Autowired
    SatelliteRepository SatelliteRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public void saveSatellite(Satellite Satellite) {
        SatelliteRepository.save(Satellite);
    }

    public Iterable<Satellite> getSatelliteHistory() {
        return SatelliteRepository.findAll();
    }

    public Optional<Satellite> getSatellite(Long id) {
        return SatelliteRepository.findById(id);
    }

    public String deleteSatellite(Long id) {
        SatelliteRepository.deleteById(id);
        return "Satellite removed !! " + id;
    }

    public Satellite updateSatellite(Satellite satellite) {
        Satellite existingSatellite = SatelliteRepository.findById(satellite.getSatelliteId()).orElse(null);
        existingSatellite.setSatelliteName(satellite.getSatelliteName());
        existingSatellite.setCountry(satellite.getCountry());
        existingSatellite.setStatus(satellite.getStatus());
        return SatelliteRepository.save(existingSatellite);

    }

	public ResponseTemplate getSatelliteWithLocation(long id) {
		ResponseTemplate vo = new ResponseTemplate();
		Satellite satellite = SatelliteRepository.findBySatelliteId(id);
		Location location = restTemplate.getForObject("http://localhost:9080/location/" + satellite.getSatelliteId(), Location.class );
	
		vo.setSatellite(satellite);
		vo.setLocation(location);
		return vo;
	}
	
}
