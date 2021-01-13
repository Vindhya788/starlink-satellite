package com.satelliteconstellation.satelliteS.repository;


import com.satelliteconstellation.satelliteS.entity.Satellite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteRepository extends CrudRepository<Satellite, Long> {

	Satellite findBySatelliteId(long id);
}
