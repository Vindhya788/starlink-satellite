package com.satelliteconstellation.satelliteS.VO;

import com.satelliteconstellation.satelliteS.entity.Satellite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplate {

	
	private Satellite satellite;
	private Location location;
	
	public void setSatellite(Satellite satellite) {
		// TODO Auto-generated method stub
		
	}
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		
	}
}
