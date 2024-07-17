package com.ligabetplay.city.Infrastructure;

import javax.swing.JOptionPane;

import com.ligabetplay.city.application.CreateCityCaseUse;
import com.ligabetplay.city.domain.entity.City;

public class CityUI {
    private CreateCityCaseUse createCityCaseUse;

    public CityUI(CreateCityCaseUse createCityCaseUse){
        this.createCityCaseUse = createCityCaseUse;
    }

    public void crear(){
        City city = new City();
        city.setId(JOptionPane.showInputDialog(null,"Ingrese el id"));
        city.setNombre(JOptionPane.showInputDialog(null,"Ingrese el nombre"));
        city.setIdRegion(Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese el idRegion")));
        createCityCaseUse.execute(city);
    }

}
