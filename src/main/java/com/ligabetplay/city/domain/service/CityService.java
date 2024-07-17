package com.ligabetplay.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.city.domain.entity.City;

public interface CityService {
    public void createCity(City city);
    public void updateCity(City city);
    public Optional<City> findCityById (String id);
    public List<City> findAllCities(); 

}
