package com.ligabetplay.city.application;

import com.ligabetplay.city.domain.entity.City;
import com.ligabetplay.city.domain.service.CityService;

public class CreateCityCaseUse {
    private CityService cityService;

    public CreateCityCaseUse(CityService cityService){
        this.cityService = cityService;
    }

    public void execute(City city){
        cityService.createCity(city);
    }

}
