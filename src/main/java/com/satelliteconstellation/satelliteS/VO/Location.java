package com.satelliteconstellation.satelliteS.VO;

import lombok.Data;

@Data
public class Location {
	
	private Long satelliteId;
    private String satelliteLocation;
    private String dateInLocation;

}